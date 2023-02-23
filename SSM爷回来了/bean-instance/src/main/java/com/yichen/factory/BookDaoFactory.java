package com.yichen.factory;

import com.yichen.dao.BookDao;
import com.yichen.dao.impl.BookDaoImpl;

public class BookDaoFactory {
    public BookDao getBookDao(){
        System.out.println("Factory running...");
        return new BookDaoImpl();
    }
}
