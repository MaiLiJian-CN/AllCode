package com.yichen.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.Dish;
import com.yichen.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetmealDao extends BaseMapper<Setmeal> {
}
