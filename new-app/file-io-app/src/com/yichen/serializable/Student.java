package com.yichen.serializable;

import java.io.Serializable;

/**
 * 对象序列化必须实现Serializable序列化接口
 */
public class Student implements Serializable {
    private String name;
    private String login;
    private transient String password;//透明不参与序列化

    public Student() {
    }

    public Student(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
