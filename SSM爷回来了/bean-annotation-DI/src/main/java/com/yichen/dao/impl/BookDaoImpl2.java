package com.yichen.dao.impl;

import com.yichen.dao.BookDao;
import org.springframework.stereotype.Repository;

//@Component("bookDao") 两个注解相同，只是表明是数据层的Bean
//表现层为Controller
@Repository("BookDaoImpl2")
public class BookDaoImpl2 implements BookDao {
    public BookDaoImpl2(){
    }

    @Override
    public void save() {
        System.out.println("Book save...2");
    }
}
