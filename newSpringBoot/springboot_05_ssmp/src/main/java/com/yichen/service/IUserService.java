package com.yichen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {
    IPage<User> getPage(int currentPage, int pageSize);
}
