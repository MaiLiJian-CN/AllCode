package com.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Student;
import com.example.servier.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStudentService {
    @Autowired
    private StudentService studentService;

    @Test
    void TestSave() {
        Student student = new Student();
        student.setGender("女");
        student.setName("syy");
        studentService.save(student);
    }

    @Test
    void TestDelete() {
        studentService.removeById(11);
    }

    @Test
    void TestGetAll() {
        studentService.getById(9);
    }

    @Test
    void TestPage() {

        IPage<Student> page = studentService.getPage(2, 3);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
    }

}
