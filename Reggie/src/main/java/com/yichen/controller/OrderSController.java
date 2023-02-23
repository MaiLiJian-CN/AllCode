package com.yichen.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.common.BaseContext;
import com.yichen.common.R;
import com.yichen.entity.OrderDetail;
import com.yichen.entity.Orders;
import com.yichen.entity.User;
import com.yichen.server.OrdersServer;
import com.yichen.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.security.PrivateKey;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderSController {
    @Autowired
    private OrdersServer ordersServer;
    @Autowired
    private UserServer userServer;

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        ordersServer.submit(orders);
        return R.success("下单成功");
    }

    @GetMapping("/userPage")
    public R<Page> page(int page,int pageSize){
        Long currentId = BaseContext.getCurrentId();
//        User user = userServer.getById(currentId);
//        Orders orders = ordersServer.getById(user.getId());

        Page<Orders> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Orders> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Orders::getUserId, currentId);
        wrapper.orderByDesc(Orders::getOrderTime);
        Page<Orders> page1 = ordersServer.page(pageInfo, wrapper);
        return R.success(page1);
//        return null;
    }
}
