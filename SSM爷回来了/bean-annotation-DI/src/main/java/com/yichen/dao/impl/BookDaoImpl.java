package com.yichen.dao.impl;

import com.yichen.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

//@Component("bookDao") 两个注解相同，只是表明是数据层的Bean
//表现层为Controller
@Repository("BookDaoImpl1")
@PropertySource("classpath:jdbc.properties")
public class BookDaoImpl implements BookDao {
    @Value("${name}")
    private String username;

    public BookDaoImpl() {
    }

    @Override
    public void save() {
        System.out.println("Book save...1:"+username);
    }
}
