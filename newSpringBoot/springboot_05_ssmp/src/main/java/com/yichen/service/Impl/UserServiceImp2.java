package com.yichen.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.dao.UserDao;
import com.yichen.domain.User;
import com.yichen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp2 implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Boolean save(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean delete(int id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public Boolean update(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public User getById(int id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.selectList(null);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return userDao.selectPage(page, null);
    }


}
