package com.example.controller;


import com.example.controller.utils.R;
import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.servier.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public R getAll() {
        return new R(true, studentService.list());
    }

    @PostMapping
    public R save(@RequestBody Student student) {

        return new R(studentService.save(student));
    }

    @PutMapping
    public R update(@RequestBody Student student) {
        return new R(studentService.updateById(student));
    }

    @PutMapping("{id}")
    public R delete(@PathVariable int id) {
        return new R(studentService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id) {
        return new R(true, studentService.getById(id));
    }

    @GetMapping("{current}/{pagesize}")
    public R getPage(@PathVariable int current, @PathVariable int pagesize) {
        return new R(true, studentService.getPage(current, pagesize));
    }
}
