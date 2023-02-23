package com.yichen.service;

import com.yichen.dao.BookDao;

public interface BookService extends BookDao {
    @Override
    void save();
}
