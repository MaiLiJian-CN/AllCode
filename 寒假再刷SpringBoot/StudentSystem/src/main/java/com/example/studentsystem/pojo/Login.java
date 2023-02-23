package com.example.studentsystem.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Login implements Serializable {
    private int identity;
    private String username;
    private String passwd;
}
