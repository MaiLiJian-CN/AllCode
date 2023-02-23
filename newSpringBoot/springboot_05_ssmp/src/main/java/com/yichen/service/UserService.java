package com.yichen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yichen.domain.User;

import java.util.List;

public interface UserService {
    Boolean save(User user);

    Boolean delete(int id);

    Boolean update(User user);

    User getById(int id);

    List<User> getAll();

    IPage<User> getPage(int currentPage, int pageSize);
}
