package com.yichen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {
}
