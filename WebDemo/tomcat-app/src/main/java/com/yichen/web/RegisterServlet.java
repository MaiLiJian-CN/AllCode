package com.yichen.web;

import com.yichen.mapper.UserMapper;
import com.yichen.pojoTest.User;
import com.yichen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user=new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);

    //调用mybatis完成查询
        /*//获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SQL Session Factory对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u = userMapper.selectByName(username);
        if (u==null){
            //可以注册
            userMapper.add(user);
            sqlSession.commit();
        }else {
            //已有用户名
            response.setContentType("text/html; charset= utf-8");
            response.getWriter().write("注册失败，用户名已经存在");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
