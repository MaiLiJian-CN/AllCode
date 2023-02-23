package com.yichen.service;

import com.yichen.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    void add(Brand brand);
}
