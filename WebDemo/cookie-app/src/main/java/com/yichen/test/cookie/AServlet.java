package com.yichen.test.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送Cookie
        //1.创建Cookie对象
        /**
         * 解决编码报错
        String value="张三";
        value = URLEncoder.encode(value, "UTF-8");
        Cookie cookie=new Cookie("name",value);
         */
        Cookie cookie=new Cookie("name",URLEncoder.encode("张三","UTF-8"));
        //2.发送Cookie. response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
