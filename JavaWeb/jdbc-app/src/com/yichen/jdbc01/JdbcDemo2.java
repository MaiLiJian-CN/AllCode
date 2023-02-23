package com.yichen.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务处理
 */
public class JdbcDemo2 {
    public static void main(String[] args) throws Exception{
        //注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/dbtest1";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);

        //定义MySQL
        String sql1="update account set money = 2000 where id=1";
        String sql2="update account set money = 2000 where id=2";
        //获取执行MySQL的对象Statement
        Statement stmt = conn.createStatement();
        //执行
        try {
            //开启事务
            conn.setAutoCommit(false);
            //执行MySQL
            int count1 = stmt.executeUpdate(sql1);//受影响行数
            int count2 = stmt.executeUpdate(sql2);//受影响行数
            //处理结果
            System.out.println(count1);
            System.out.println(count2);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }

        //释放资源
        stmt.close();
        conn.close();
    }
}
