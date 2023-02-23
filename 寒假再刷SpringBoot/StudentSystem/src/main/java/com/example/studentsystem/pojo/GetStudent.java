package com.example.studentsystem.pojo;

import lombok.Data;

import java.io.Serializable;

//学生的实体类
@Data
public class GetStudent implements Serializable {
    private int id;
    private String name;
    private int age;
    private String school;
}
