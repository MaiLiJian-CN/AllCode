package com.mlj.Dao;

import java.sql.SQLException;
import java.util.List;
import com.mlj.pojo.User;
public interface UserDao {
    List<User> getUserList() throws SQLException, ClassNotFoundException;
}
