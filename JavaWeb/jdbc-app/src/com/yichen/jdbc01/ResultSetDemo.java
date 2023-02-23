package com.yichen.jdbc01;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {

    @Test
    public void testDQL() throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql:///dbtest1?useSSL=false";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //定义MySQL
        String sql="select * from account";
        //获取执行MySQL的对象Statement
        Statement stmt = conn.createStatement();
        //执行
        ResultSet rs=stmt.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getDouble(3));
            System.out.println("======================");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
