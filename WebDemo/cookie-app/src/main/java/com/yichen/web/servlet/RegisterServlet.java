package com.yichen.web.servlet;

import com.yichen.pojo.User;
import com.yichen.service.UserServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserServlet servlet=new UserServlet();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        String username = request.getParameter("username");
        user.setUsername(username);
        String password = request.getParameter("password");
        user.setPassword(password);

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
//        checkCodeGen=checkCodeGen.toLowerCase();
        if (!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }


        boolean register = servlet.register(user);
        if (register){
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
