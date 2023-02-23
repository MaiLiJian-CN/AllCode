package com.yichen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBookService {

    @Autowired
    private BookService bookService;


    @Test
    void TestSave() {
        Book book = new Book();
        book.setName("mysql零基础教程");
        book.setType("计算机类");
        book.setDescription("适合初学者入门");
        bookService.save(book);
    }

    @Test
    void TestGetpage() {
        IPage<Book> page = bookService.getPage(2, 4);
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
    }

    @Test
    void TestAll() {
        System.out.println(bookService.list());
    }

}
