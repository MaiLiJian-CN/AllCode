package com.example.studentsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentsystem.pojo.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao extends BaseMapper<Login> {
}
