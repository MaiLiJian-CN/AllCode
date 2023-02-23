package com.mlj.Dao;

import com.mlj.Utils.DbUtil;
import com.mlj.pojo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DbUtil implements UserDao
{
    @Override
    public List<User> getUserList() throws SQLException, ClassNotFoundException {
        Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        List<User> list=new ArrayList<>();
        User user=new User();
        System.out.println("1111111111");
        while (resultSet.next()){
            String name = resultSet.getString("name");
            user.setName(name);
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setId(resultSet.getInt("id"));
            list.add(user);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }
}
