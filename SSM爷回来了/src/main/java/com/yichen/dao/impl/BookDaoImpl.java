package com.yichen.dao.impl;

import com.yichen.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("Book save...");
    }
}
