package com.yichen.jdbc01;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;

public class Prepared_UserLogin {

    @Test
    public void testLogin() throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql:///test?useServerPrepStmts=true";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //接收用户输入数据
/**
 String name="zhangsan";
 String pwd="123";
 */
        //sql注入
        String name="zhangsan";
        String pwd="' or '1' = '1";
        String sql="select * from user where username = ? and password = ?";
        System.out.println(sql);

        //获取ppts对象
        PreparedStatement ppst=conn.prepareStatement(sql);
        //设置参数
        ppst.setString(1,name);
        ppst.setString(2,pwd);
        //执行sql
        ResultSet rs = ppst.executeQuery();
        if (rs.next()) System.out.println("登录成功");else System.out.println("登陆失败");

        rs.close();
        ppst.close();
        conn.close();
    }
}
