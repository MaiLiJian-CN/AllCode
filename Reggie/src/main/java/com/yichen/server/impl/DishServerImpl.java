package com.yichen.server.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.CategoryDao;
import com.yichen.dao.DishDao;
import com.yichen.dto.DishDto;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;
import com.yichen.entity.DishFlavor;
import com.yichen.server.CategoryServer;
import com.yichen.server.DishFlavorServer;
import com.yichen.server.DishServer;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServerImpl extends ServiceImpl<DishDao, Dish> implements DishServer {
    @Autowired
    private DishFlavorServer dishFlavorServer;

    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);

        Long dishDtoId = dishDto.getId();
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((food)->{
            food.setDishId(dishDtoId);
            return food;
        }).collect(Collectors.toList());
        dishFlavorServer.saveBatch(flavors);
    }

    @Transactional
    public DishDto getByIdWithFlavor(Long id) {
        Dish dish = this.getById(id);
        DishDto dishDto=new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper=new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> dishFlavors = dishFlavorServer.list(dishFlavorLambdaQueryWrapper);
        dishDto.setFlavors(dishFlavors);
        return dishDto;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        this.updateById(dishDto);

        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper=new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorServer.remove(dishFlavorLambdaQueryWrapper);
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors =  flavors.stream().map((food)->{
            food.setDishId(dishDto.getId());
            return food;
        }).collect(Collectors.toList());
        dishFlavorServer.saveBatch(flavors);
    }




}
