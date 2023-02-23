package com.example.testshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
