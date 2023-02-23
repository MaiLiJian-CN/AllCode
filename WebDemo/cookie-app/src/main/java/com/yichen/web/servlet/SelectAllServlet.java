package com.yichen.web.servlet;

import com.yichen.pojo.Brand;
import com.yichen.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
//public class SelectAllServlet extends HttpServlet {
//
//    private BrandService service=new BrandService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //调用Brand Service查询
//        List<Brand> brands = service.selectAll();
//        //存入request域中
//        request.setAttribute("brands",brands);
//        //转发brand.jsp
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request,response);
//    }
//}
