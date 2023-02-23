package com.yichen.dao.impl;

import com.yichen.dao.BookDao;

public class BookDaoImpl implements BookDao {
    public BookDaoImpl(){
        System.out.println("BookDao constructor is running~ ");
    }

    @Override
    public void save() {
        System.out.println("Book save...");
    }
}
