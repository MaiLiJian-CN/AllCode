package com.yichen.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class smpApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        userDao.selectById(1);
    }

    @Test
    void UserSave() {
        User user = new User();
        user.setUsername("hyy");
        user.setPassword("111");
        userDao.insert(user);
    }

    @Test
    void UserDelete() {
        User user = new User();
        user.setId(15);
        userDao.deleteById(user.getId());

    }

    @Test
    void UserQuery() {
        userDao.selectList(null);
    }

    @Test
    void UserSelectPage() {
        IPage page = new Page(1, 5);
        userDao.selectPage(page, null);
    }

    @Test
    void UserGetBy() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "mlj");
        userDao.selectList(queryWrapper);
    }

    @Test
    void UserGetBy2() {
        String username = "mlj1";
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(username != null, User::getUsername, username);
        userDao.selectList(queryWrapper);
    }


}
