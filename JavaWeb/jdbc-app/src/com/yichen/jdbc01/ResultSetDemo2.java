package com.yichen.jdbc01;

import org.junit.jupiter.api.Test;
import pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultSetDemo2 {
    @Test
    public void testDemo() throws Exception{
        //Connection获取链接
        String url="jdbc:mysql://127.0.0.1:3306/dbtest1";
        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql="select * from account";
        //创建对象
        Statement statement = connection.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        List<Account> list=new ArrayList<>();

        while (rs.next()){
            Account acc=new Account();
            acc.setId(rs.getInt("id"));
            acc.setName(rs.getString("name"));
            acc.setMoney(rs.getDouble("money"));
            list.add(acc);
        }
        for (Account account : list) {
            System.out.println(account.getId()+" "+account.getName()+" "+account.getMoney());
        }
        rs.close();
        statement.close();
        connection.close();

    }
}
