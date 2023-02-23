package com.example.testshop.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.DishDao;
import com.yichen.dao.SetmealDao;
import com.yichen.dto.SetmealDto;
import com.yichen.entity.Dish;
import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;
import com.yichen.server.DishServer;
import com.yichen.server.SetmealDishServer;
import com.yichen.server.SetmealServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServerImpl extends ServiceImpl<SetmealDao, Setmeal> implements SetmealServer {
        @Autowired
        private SetmealDishServer dishServer;
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((info)->{
            info.setSetmealId(setmealDto.getId());
            return info;
        }).collect(Collectors.toList());
        dishServer.saveBatch(setmealDishes);

    }
}
