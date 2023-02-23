package com.yichen.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String email;

    public User(Integer id, String username, String password, Integer age, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
