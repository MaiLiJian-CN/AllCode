package com.yichen;

import com.yichen.dao1.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04MybatisApplicationTests {
    @Autowired
    private BookDao book;

    @Test
    void contextLoads() {
        System.out.println(book.getById(1));
    }

}
