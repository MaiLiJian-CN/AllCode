package com.yichen.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishDao extends BaseMapper<Dish> {
}
