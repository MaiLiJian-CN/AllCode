package com.yichen.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yichen.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest2 {
    @Autowired
    private IUserService userService;

    @Test
    void UserGetById() {
        System.out.println(userService.getById(4));
    }

    @Test
    void UserSave() {
        User user = new User();
        user.setUsername("hyy");
        user.setPassword("1234");
        userService.save(user);
    }

    @Test
    void UserDelete() {
        userService.removeById(15);
    }

    @Test
    void testGetAll() {
        System.out.println(userService.list());
    }

    @Test
    void UserUpdate() {
        User user = new User();
        user.setId(16);
        user.setUsername("=====");
        user.setPassword(">>>>>>");
        System.out.println(userService.updateById(user));
    }

}
