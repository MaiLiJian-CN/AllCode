package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.Service.BookUserService;
import com.example.pojo.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private BookUserService bookUserService;

    @GetMapping("/findAll")
    public List<BookUser> findAll(){
        List<BookUser> users = bookUserService.findAll();
        System.out.println(users);
        return users;
    }
    @PostMapping("/selectUser")
    public Object selectUser(@RequestBody JSONObject object){
        System.out.println(object.toJSONString());
        String username= object.getString("username");
        String passwd=object.getString("passwd");
        BookUser user = bookUserService.selectUser(username, passwd);
        return "Success:"+user.getUsername()+","+user.getUserAccount();
    }
}
