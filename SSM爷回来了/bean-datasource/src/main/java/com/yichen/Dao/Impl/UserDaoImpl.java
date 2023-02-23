package com.yichen.Dao.Impl;

import com.yichen.Dao.UserDao;

public class UserDaoImpl implements UserDao {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("User Dao save..."+name);
    }
}
