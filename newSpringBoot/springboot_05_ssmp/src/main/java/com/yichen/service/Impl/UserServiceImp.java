package com.yichen.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.UserDao;
import com.yichen.domain.User;
import com.yichen.service.IUserService;
import com.yichen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends ServiceImpl<UserDao, User> implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage<User> page = new Page<>(currentPage, pageSize);
        userDao.selectPage(page, null);
        return page;
    }
}
