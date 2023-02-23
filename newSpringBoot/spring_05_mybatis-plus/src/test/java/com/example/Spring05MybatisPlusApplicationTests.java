package com.example;

import com.example.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring05MybatisPlusApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
//        System.out.println(userDao.selectById(1));
        System.out.println(userDao.selectList(null) + "\t");
    }

}
