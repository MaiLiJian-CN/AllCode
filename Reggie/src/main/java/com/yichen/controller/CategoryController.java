package com.yichen.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.common.R;
import com.yichen.entity.Category;
import com.yichen.server.CategoryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServer categoryServer;

    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryServer.save(category);
        return R.success("成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize){
        Page<Category> pageInfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        categoryServer.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    @DeleteMapping
    public R<String> remove(@RequestParam Long ids){
        categoryServer.remove(ids);
        return R.success("成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("修改信息分类：{}",category);
        categoryServer.updateById(category);
        return R.success("修改成功");
    }
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        LambdaQueryWrapper<Category> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(category.getType()!=null,Category::getType,category.getType());
        lambdaQueryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list=categoryServer.list(lambdaQueryWrapper);
        return R.success(list);
    }

//    @DeleteMapping
//    public R<String> remove(@RequestParam Category category){
//        categoryServer.removeById(category);
//        return R.success("删除成功");
//    }

}
