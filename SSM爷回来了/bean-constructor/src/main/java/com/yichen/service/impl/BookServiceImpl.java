package com.yichen.service.impl;

import com.yichen.dao.BookDao;
import com.yichen.service.BookService;

public class BookServiceImpl implements BookService{
    public BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void save() {
            bookDao.save();
    }

    public BookServiceImpl() {
    }
}
