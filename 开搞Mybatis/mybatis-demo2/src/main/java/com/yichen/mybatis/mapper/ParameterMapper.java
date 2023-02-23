package com.yichen.mybatis.mapper;

import com.yichen.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /*获取所有人信息*/
    List<User> getAllUser();

    /*通过名字获取信息*/
    User getUserByName(String username);

    //多个查询条件获取信息
    User checkLogin(String username,String password);
    //多个查询条件获取信息
    User checkLoginByMap(Map<String,String> map);

    int insertByUser(User user);

    User checkByParam(@Param("username") String name,@Param("passwd") String password);
}
