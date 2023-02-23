package com.example.mybatisdemo1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisdemo1.mapper.UserMapper;
import com.example.mybatisdemo1.pojo.User;
import com.example.mybatisdemo1.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
