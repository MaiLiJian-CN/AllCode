package com.example.testshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yichen.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
}
