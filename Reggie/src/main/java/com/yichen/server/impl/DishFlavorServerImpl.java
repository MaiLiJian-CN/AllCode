package com.yichen.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.DishDao;
import com.yichen.dao.DishFlavorDao;
import com.yichen.entity.DishFlavor;
import com.yichen.server.DishFlavorServer;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServerImpl extends ServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorServer {
}
