package com.yichen.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.common.BaseContext;
import com.yichen.common.CustomException;
import com.yichen.dao.OrderDao;
import com.yichen.dao.OrderDetailDao;
import com.yichen.dao.ShoppingCartDao;
import com.yichen.entity.*;
import com.yichen.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
//import org.springframework.core.annotation.Order;

@Service
public class OrdersServerImpl extends ServiceImpl<OrderDao, Orders> implements OrdersServer {
    @Autowired
    private ShoppingCartServer shoppingCartServer;

    @Autowired
    private UserServer userServer;

    @Autowired
    private AddressBookServer addressBookServer;

    @Autowired
    private OrderDetailServer orderDetailServer;

    @Transactional
    public void submit(Orders orders){
        //获取用户id
        Long currentId = BaseContext.getCurrentId();
        //查询购物车
//        ShoppingCart shoppingCart = shoppingCartServer.getById(currentId);
        LambdaQueryWrapper<ShoppingCart> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ShoppingCart::getUserId,currentId);
        List<ShoppingCart> shoppingCarts = shoppingCartServer.list(wrapper);

//        查用户
        User user = userServer.getById(currentId);
        Long addressBookId = orders.getAddressBookId();
//        查地址
        AddressBook addressBook = addressBookServer.getById(addressBookId);
        if (addressBook==null){
            throw new CustomException("地址有误");
        }
        long orderId = IdWorker.getId();//订单号

        AtomicInteger amount = new AtomicInteger(0);

        List<OrderDetail> orderDetails = shoppingCarts.stream().map((item) -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());
            amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
            return orderDetail;
        }).collect(Collectors.toList());


        orders.setId(orderId);
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        orders.setAmount(new BigDecimal(amount.get()));//总金额
        orders.setUserId(currentId);
        orders.setNumber(String.valueOf(orderId));
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(addressBook.getPhone());
        orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));

        this.save(orders);

        orderDetailServer.saveBatch(orderDetails);

        shoppingCartServer.remove(wrapper);


    }
}
