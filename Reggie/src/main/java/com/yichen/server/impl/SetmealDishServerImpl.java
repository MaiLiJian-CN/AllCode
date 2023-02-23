package com.yichen.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.SetmealDao;
import com.yichen.dao.SetmealDishDao;
import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;
import com.yichen.server.SetmealDishServer;
import com.yichen.server.SetmealServer;
import org.springframework.stereotype.Service;

@Service
public class SetmealDishServerImpl extends ServiceImpl<SetmealDishDao, SetmealDish> implements SetmealDishServer {
}
