package com.yichen.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.dto.DishDto;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;

public interface DishServer extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);


}
