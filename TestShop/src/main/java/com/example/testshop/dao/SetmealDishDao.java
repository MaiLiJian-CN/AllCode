package com.example.testshop.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetmealDishDao extends BaseMapper<SetmealDish> {
}
