package com.example.testshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartDao extends BaseMapper<ShoppingCart> {
}
