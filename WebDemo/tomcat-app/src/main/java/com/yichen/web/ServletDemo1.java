package com.yichen.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet Hello World");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {

    }
}
