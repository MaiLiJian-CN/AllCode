package com.example.servier.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.servier.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public IPage<Student> getPage(int currentPage, int pageSize) {
        IPage<Student> page = new Page<>(currentPage, pageSize);
        studentDao.selectPage(page, null);
        return page;
    }
}
