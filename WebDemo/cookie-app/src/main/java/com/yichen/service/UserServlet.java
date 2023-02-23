package com.yichen.service;

import com.yichen.mapper.UserMapper;
import com.yichen.pojo.User;
import com.yichen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServlet {
    SqlSessionFactory factory=SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username,String password){

        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        return user;

    }

    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.selectByUsername(user.getUsername());
        if (u==null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u==null;
    }
}
