package com.example.studentsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.studentsystem.common.R;
import com.example.studentsystem.pojo.Login;
import com.example.studentsystem.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginServer loginServer;

    @GetMapping
    public R<Login> Login(Login user){
        R<Login> r = new R<>();
        int id = user.getIdentity();
        String username = user.getUsername();
        String passwd = user.getPasswd();
        if (username==null||passwd==null){
            r.setCode(400);
            return r;
        };
        LambdaQueryWrapper<Login> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Login::getIdentity,user.getIdentity());
        wrapper.eq(Login::getPasswd,user.getPasswd());
        wrapper.eq(Login::getUsername,user.getUsername());
        Login u = loginServer.getOne(wrapper);
        if (u!=null && u.getIdentity()==id&&u.getPasswd().equals(passwd)&&u.getUsername().equals(username)){
            r.setCode(200);
            return r;
        }else {
            r.setCode(400);
            r.error("登录信息有误");
            return r;
        }
    }

}
