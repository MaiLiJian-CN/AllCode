package com.yichen.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int age;
    private String email;

}
