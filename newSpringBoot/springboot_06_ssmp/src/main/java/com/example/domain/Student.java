package com.example.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student")
@Data
public class Student {
    private int id;
    private String name;
    private String gender;

}
