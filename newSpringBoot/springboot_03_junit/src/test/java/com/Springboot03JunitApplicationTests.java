package com;

import com.yichen.Springboot03JunitApplication;
import com.yichen.dao1.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot03JunitApplication.class)
//@ContextConfiguration(classes = Springboot03JunitApplication.class)
class Springboot03JunitApplicationTests {
    @Autowired
    private Book book;

    @Test
    void contextLoads() {
        book.save();
    }

}
