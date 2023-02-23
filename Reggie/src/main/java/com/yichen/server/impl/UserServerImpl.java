package com.yichen.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.SetmealDishDao;
import com.yichen.dao.UserDao;
import com.yichen.entity.SetmealDish;
import com.yichen.entity.User;
import com.yichen.server.SetmealDishServer;
import com.yichen.server.UserServer;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl extends ServiceImpl<UserDao, User> implements UserServer {

}
