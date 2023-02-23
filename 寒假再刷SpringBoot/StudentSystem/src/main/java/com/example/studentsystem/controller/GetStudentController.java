package com.example.studentsystem.controller;

import com.example.studentsystem.common.R;
import com.example.studentsystem.pojo.GetStudent;
import com.example.studentsystem.server.GetStudentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/getStudent")
public class GetStudentController {
    @Autowired
    private GetStudentServer getStudent;

    @PostMapping
    public R<GetStudent> add(GetStudent student) {
        log.info("student:{}", student);

        getStudent.save(student);
        return R.success(student);
    }

    @GetMapping("/{id}")
    public R get(@PathVariable int id) {
        GetStudent student = getStudent.getById(id);
        if (student != null) {
            return R.success(student);
        } else {
            return R.error("没有找到该对象");
        }
    }
    @GetMapping("/getAll")
    public List<GetStudent> getAllStudent(){
        List<GetStudent> list = getStudent.list();
        if (list!=null){
            return  list;
        }else {
            return null;
        }
    }
    @PostMapping("/delete/{id}")
    public R delete(@PathVariable int id){
        R<Object> objectR = new R<>();
        boolean b = getStudent.removeById(id);
        if (b){
            objectR.setCode(200);
            return objectR;
        }else {
            objectR.setCode(400);
            return objectR;
        }
    }
    @PostMapping("/update")
    public R update(GetStudent student){
        R<Object> objectR = new R<>();
        int id = student.getId();
        String name = student.getName();
        int age = student.getAge();
        String school = student.getSchool();
        boolean b = getStudent.updateById(student);
        if (b){
            objectR.setCode(200);
            return objectR;
        }else {
            objectR.setCode(400);
            return objectR;
        }
    }
}
