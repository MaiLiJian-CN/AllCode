package com.example.testshop.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.OrderDetailDao;
import com.yichen.entity.OrderDetail;
import com.yichen.server.OrderDetailServer;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServerImpl extends ServiceImpl<OrderDetailDao, OrderDetail> implements OrderDetailServer {
}
