package com.mlj.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name ="AddServlet",urlPatterns = "/02/add1")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String like = req.getParameter("like");
        String intro = req.getParameter("intro");
        System.out.println(name);
        System.out.println(sex);
        System.out.println(like);
        System.out.println(intro);
    }

}
