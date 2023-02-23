package com.yichen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yichen.domain.User;
import com.yichen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/users")
public class UserController2 {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public List<User> getAll() {
        return iUserService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody User user) {
        return iUserService.save(user);
    }

    @PutMapping
    public Boolean update(@RequestBody User user) {
        return iUserService.updateById(user);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable int id) {
        return iUserService.removeById(id);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return iUserService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<User> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return iUserService.getPage(currentPage, pageSize);
    }
}
