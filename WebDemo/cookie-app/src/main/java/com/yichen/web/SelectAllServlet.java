package com.yichen.web;

import com.alibaba.fastjson.JSON;
import com.yichen.pojo.Brand;
import com.yichen.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandService brandService=new BrandService();
        //调用Service查询
        List<Brand> brands = brandService.selectAll();
        //序列化
        String jsonString = JSON.toJSONString(brands);

        //响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
