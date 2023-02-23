package com.yichen.service.Impl;

import com.yichen.dao.BookDao;
import com.yichen.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
    public void setBookDao(BookDao bookDao){
        this.bookDao=bookDao;
    }


}
