package com.yichen.jdbc01;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserLogin {
    @Test
    public void testDMl() throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //接收用户输入数据
/**
        String name="zhangsan";
        String pwd="123";
   */
        //sql注入
        String name="zhangsandgvrgf";
        String pwd="' or '1' = '1";
        String sql="select * from user where username ='"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);

        //获取stmt对象
        Statement stmt=conn.createStatement();
        //执行sql
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) System.out.println("登录成功");else System.out.println("登陆失败");

        rs.close();
        stmt.close();
        conn.close();
    }
}
