package com.example.servier;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Student;

public interface StudentService extends IService<Student> {
    IPage<Student> getPage(int currentPage, int pageSize);
}
