package com.yichen.bean;

/**
 * 父类用户
 */
public class User {
    private String loginName;
    private String username;
    private String password;
    private char sex;
    private String phone;
    private double money;

    public User() {
    }

    public User(String loginName, String username, String password, char sex, String phone, double money) {
        this.loginName = loginName;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.money = money;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
