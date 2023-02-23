package com.yichen.dao.impl;

import com.yichen.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("Book dao save...");
    }

    public void init(){
        System.out.println("init...");
    }
    public void destroy(){
        System.out.println("destroy...");
    }
}
