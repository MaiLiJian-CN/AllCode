package com.yichen.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void UserSave() {
        User user = new User();
        user.setUsername("hyy");
        user.setPassword("1234");
        userService.save(user);
    }

    @Test
    void UserDelete() {
        userService.delete(15);
    }

    @Test
    void UserUpdate() {
        User user = new User();
        user.setId(17);
        user.setUsername("hyy2");
        user.setPassword("1111");
        userService.update(user);
    }

    @Test
    void UserGetAll() {
        userService.getAll();
    }

    @Test
    void UserGetPage() {

        IPage<User> byPage = userService.getPage(2, 5);
        System.out.println(byPage.getTotal());
        System.out.println(byPage.getPages());
        System.out.println(byPage.getSize());
        System.out.println(byPage.getRecords());
        System.out.println(byPage.getCurrent());

    }

    @Test
    void UserSelectPage() {
//        IPage page=new Page(1,5);
        IPage<User> page = userService.getPage(1, 2);
        System.out.println(page.getRecords());

    }

    @Test
    void UserPage() {
        IPage<User> page = userService.getPage(2, 4);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getClass());
    }

}
