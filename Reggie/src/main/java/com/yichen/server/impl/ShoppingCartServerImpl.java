package com.yichen.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.ShoppingCartDao;
import com.yichen.entity.ShoppingCart;
import com.yichen.server.ShoppingCartServer;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServerImpl extends ServiceImpl<ShoppingCartDao, ShoppingCart> implements ShoppingCartServer {
}
