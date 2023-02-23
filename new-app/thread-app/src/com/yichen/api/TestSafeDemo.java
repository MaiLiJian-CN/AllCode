package com.yichen.api;

public class TestSafeDemo {
    public static void main(String[] args) {
        //定义线程类，创建共享账户
        Account acc=new Account("mlj",10000);
        //创建2个线程对象
        new DrawDemo(acc,"小明").start();
        new DrawDemo(acc,"小红").start();
    }
}
