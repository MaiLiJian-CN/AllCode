package com.yichen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Orders> {
}
