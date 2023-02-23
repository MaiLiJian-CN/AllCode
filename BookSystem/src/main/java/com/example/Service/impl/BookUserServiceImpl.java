package com.example.Service.impl;
import com.example.Service.BookUserService;
import com.example.mapper.UserMapper;
import com.example.pojo.BookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
public class BookUserServiceImpl implements BookUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<BookUser> findAll() {
        List<BookUser> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public BookUser selectUser(String username, String passwd) {
        BookUser users = userMapper.selectUser(username, passwd);
        return users;
    }
}
