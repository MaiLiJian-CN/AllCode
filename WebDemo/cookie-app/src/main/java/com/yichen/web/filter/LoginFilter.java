//package com.yichen.web.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest req= (HttpServletRequest) request;
//        String[] urls={"/login,jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
//        String url = req.getRequestURI().toString();
//        for (String s : urls) {
//            if (url.contains(s)){
//                chain.doFilter(request, response);
//                return;
//            }
//        }
//
//
//        //判断session是否有user
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("user");
//        if (user!=null){
//        chain.doFilter(request, response);
//        }else {
//            req.setAttribute("login_msg","您尚未登陆！");
//            req.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
//
//    }
//}
