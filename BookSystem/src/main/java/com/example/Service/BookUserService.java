package com.example.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.BookUser;

import java.util.List;

public interface BookUserService {
     List<BookUser> findAll();

     BookUser selectUser(String username,String passwd);
}
