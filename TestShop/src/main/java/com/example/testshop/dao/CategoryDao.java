package com.example.testshop.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
