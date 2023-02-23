package com.yichen.service.impl;

import com.yichen.dao.BookDao;
import com.yichen.service.BookService;

public class BookServiceImpl implements BookService{
    //删除业务层中使用new方式创建的dao对象
    //private BookDao bookDao=new BookDaoImpl();
    private BookDao bookDao;


    @Override
    public void save() {
            System.out.println("bookService save...");
            bookDao.save();
    }
    /*提供set方法*/
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

}
