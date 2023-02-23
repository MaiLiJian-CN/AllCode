package com.yichen.dao.impl;

import com.yichen.dao.BookDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("bookDao") 两个注解相同，只是表明是数据层的Bean
//表现层为Controller
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    public BookDaoImpl(){
    }

    @Override
    public void save() {
        System.out.println("Book save...");
    }
}
