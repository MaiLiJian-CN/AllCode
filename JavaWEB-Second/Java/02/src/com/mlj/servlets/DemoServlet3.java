package com.mlj.servlets;

import com.mlj.Dao.UserDao;
import com.mlj.Dao.UserDaoImpl;
import com.mlj.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = {"/index"})
public class DemoServlet3 extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao =new UserDaoImpl();
        List<User> userList=null;
        try {
            userList = userDao.getUserList();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("list",userList);

        super.processTemplate("index",req,resp);
    }
}
