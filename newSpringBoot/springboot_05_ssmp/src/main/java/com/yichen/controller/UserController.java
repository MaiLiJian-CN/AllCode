package com.yichen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yichen.controller.utils.R;
import com.yichen.domain.User;
import com.yichen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")

public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    public R getAll() {
//        return iUserService.list();
        return new R(true, iUserService.list());
    }

    @PostMapping
    public R save(@RequestBody User user) {
//        return iUserService.save(user);
        return new R(iUserService.save(user));
    }

    @PutMapping
    public R update(@RequestBody User user) {
//        return  iUserService.updateById(user);
        return new R(iUserService.updateById(user));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id) {
//        return iUserService.removeById(id);
        return new R(iUserService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id) {
//        return iUserService.getById(id);
        return new R(true, iUserService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        return iUserService.getPage(currentPage,pageSize);
        return new R(true, iUserService.getPage(currentPage, pageSize));
    }
}
