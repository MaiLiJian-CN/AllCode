package com.yichen.mybatis.mapper;

import com.yichen.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * Mybatis面向接口编程的两个一致
     * 1.映射文件的namespace要和mapper接口的全类名一致
     * 2.映射文件中的SQL语句的id要和mapper接口的方法名一致
     * @return
     */

    int insertUser();

    int updateUser();

    int deleteUser();

    User selectUser();

    List<User> selectAllUser();
}
