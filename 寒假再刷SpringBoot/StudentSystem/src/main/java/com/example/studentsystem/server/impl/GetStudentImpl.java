package com.example.studentsystem.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.studentsystem.dao.GetStudentDao;
import com.example.studentsystem.pojo.GetStudent;
import com.example.studentsystem.server.GetStudentServer;
import org.springframework.stereotype.Service;

@Service
public class GetStudentImpl extends ServiceImpl<GetStudentDao, GetStudent> implements GetStudentServer {
}
