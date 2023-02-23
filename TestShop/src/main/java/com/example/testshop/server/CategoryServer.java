package com.example.testshop.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.dao.CategoryDao;
import com.yichen.entity.Category;

public interface CategoryServer extends IService<Category> {
    public void remove(Long ids);
}
