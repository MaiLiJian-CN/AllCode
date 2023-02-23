package com.example.studentsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentsystem.pojo.GetStudent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GetStudentDao extends BaseMapper<GetStudent> {
}
