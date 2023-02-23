package com.example.studentsystem.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.studentsystem.dao.LoginDao;
import com.example.studentsystem.pojo.Login;
import com.example.studentsystem.server.LoginServer;
import org.springframework.stereotype.Service;

@Service
public class LoginServerImpl extends ServiceImpl<LoginDao, Login> implements LoginServer {
}
