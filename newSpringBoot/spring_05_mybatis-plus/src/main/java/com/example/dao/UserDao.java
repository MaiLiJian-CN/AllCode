package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domin.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<user> {

}
