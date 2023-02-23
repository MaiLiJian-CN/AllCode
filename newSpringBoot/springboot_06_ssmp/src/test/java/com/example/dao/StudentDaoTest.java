package com.example.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    void TestSave() {
        Student student = new Student();
        student.setName("lx");
        student.setGender("男");
        studentDao.insert(student);
    }

    @Test
    void TestGetAll() {
        studentDao.selectList(null);
    }

    @Test
    void TestGetById() {
        studentDao.selectById(8);
    }

    @Test
    void TestGetPage() {
        IPage<Student> page = new Page<>(2, 3);
        studentDao.selectPage(page, null);
    }
}
