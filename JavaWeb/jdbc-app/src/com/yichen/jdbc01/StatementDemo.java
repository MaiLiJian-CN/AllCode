package com.yichen.jdbc01;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class StatementDemo {
    @Test
    public void testDDl() throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/dbtest1";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //定义MySQL
        String sql="update account set money = 3000 where id=3";
        //获取执行MySQL的对象Statement
        Statement stmt = conn.createStatement();
        //执行
        int count = stmt.executeUpdate(sql);//受影响行数
        if (count>0) System.out.println("修改成功");else System.out.println("修改失败");

        //释放资源
        stmt.close();
        conn.close();
    }
    @Test
    public void testDMl() throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/dbtest1";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //定义MySQL
        String sql="drop database db2 ";
        //获取执行MySQL的对象Statement
        Statement stmt = conn.createStatement();
        //执行
        int count = stmt.executeUpdate(sql);//受影响行数
        if (count>0) System.out.println("修改成功");else System.out.println("修改失败");

        //释放资源
        stmt.close();
        conn.close();
    }

}
