package com.yichen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.yichen.dao.BookDao;

@SpringBootTest
class Springboot0402MybatisApplicationTests {
    @Autowired
    private BookDao book;

    @Test
    void contextLoads() {
        System.out.println(book.getById(1));
    }
}