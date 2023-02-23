package com.yichen;

import com.yichen.mybatis.mapper.ParameterMapper;
import com.yichen.mybatis.pojo.User;
import com.yichen.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapper {
    @Test
    public void testGetAllUser(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
    @Test
    public void testGetUserByName(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User admin = mapper.getUserByName("admin");
        System.out.println(admin);
    }
    @Test
    public void testCheckLogin(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User admin = mapper.checkLogin("admin","123456");
        System.out.println(admin);
    }
    @Test
    public void testCheckLoginMap(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        Map<String,String> map=new HashMap<>();
        map.put("username","admin");
        map.put("passwd","123456");
        User admin = mapper.checkLoginByMap(map);
        System.out.println(admin);
    }
    @Test
    public void insertByUserTest(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User user = new User(null, "麦立健2", "123456", 20, "123@qq.com");
        int rs = mapper.insertByUser(user);
        System.out.println(user);
        Assert.assertEquals(1,rs);
    }
    @Test
    public void checkByParam(){
        SqlSession session = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        User user = mapper.checkByParam("麦立健", "123456");
        System.out.println(user);
    }


}
