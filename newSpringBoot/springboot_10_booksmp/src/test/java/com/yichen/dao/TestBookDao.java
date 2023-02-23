package com.yichen.dao;

import com.yichen.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBookDao {
    @Autowired
    private BookDao bookDao;

    @Test
    void TestGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void TestUpdate() {
        Book book = new Book();
        book.setId(7);
        book.setType("计算机类");
        book.setDescription("一本非常不错的书");
        book.setName("JavaWeb深入浅出");
        bookDao.updateById(book);
    }

    @Test
    void TestDelete() {
        bookDao.deleteById(7);
    }

    @Test
    void TestAdd() {
        Book book = new Book();
        book.setType("计算机类");
        book.setName("solidity");
        book.setDescription("狗都不学");
        bookDao.insert(book);
    }
}
