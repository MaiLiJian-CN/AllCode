package com.example.testshop.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.dao.SetmealDao;
import com.yichen.dto.SetmealDto;
import com.yichen.entity.Dish;
import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;

public interface SetmealServer extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);
}
