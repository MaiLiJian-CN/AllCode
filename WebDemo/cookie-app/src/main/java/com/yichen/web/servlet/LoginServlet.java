package com.yichen.web.servlet;

import com.yichen.pojo.User;
import com.yichen.service.UserServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserServlet servlet=new UserServlet();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //调用方法
        User user = servlet.login(username, password);

        //判断
        if (user !=null){
            //登陆成功
            //将user对象存储
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if ("1".equals(remember)){
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);
                c_username.setMaxAge(60*60);
                c_password.setMaxAge(60*60);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //重定向
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else {
            //登录失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或者密码错误");

            //转发到login0.sp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
