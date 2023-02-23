package com.yichen.dao.impl;

import com.yichen.dao.BookDao;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println(LocalDateTime.now());
        System.out.println("bookDao save...");
    }

    @Override
    public void update() {
        System.out.println("bookDao update...");
    }
}
