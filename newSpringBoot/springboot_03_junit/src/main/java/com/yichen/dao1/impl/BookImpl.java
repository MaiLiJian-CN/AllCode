package com.yichen.dao1.impl;

import com.yichen.dao1.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookImpl implements Book {
    @Override
    public void save() {
        System.out.println("save book");
    }
}
