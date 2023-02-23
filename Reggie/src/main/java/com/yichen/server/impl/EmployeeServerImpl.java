package com.yichen.server.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yichen.dao.EmployeeDao;
import com.yichen.entity.Employee;
import com.yichen.server.EmployeeServer;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServerImpl extends ServiceImpl<EmployeeDao, Employee> implements EmployeeServer {
}
