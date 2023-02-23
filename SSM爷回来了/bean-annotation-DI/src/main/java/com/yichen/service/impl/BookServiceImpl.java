package com.yichen.service.impl;

import com.yichen.dao.BookDao;
import com.yichen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//等同于@Component,只是表明这是业务层的Bean
@Service
public class BookServiceImpl implements BookService {
    @Autowired
//    @Qualifier("BookDaoImpl2")
    @Qualifier("BookDaoImpl1")
    private BookDao bookDao;


    @Override
    public void save() {
            System.out.println("bookService save...");
            bookDao.save();
    }

}
