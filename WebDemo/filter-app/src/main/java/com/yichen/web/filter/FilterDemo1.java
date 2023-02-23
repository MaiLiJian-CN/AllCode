package com.yichen.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebFilter("/*")
public class FilterDemo1 implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("1.doFilter...........");
        chain.doFilter(request,response);
        System.out.println("3.doFilter...........");
    }

    public void destroy() {
//        Filter.super.destroy();
    }
}
