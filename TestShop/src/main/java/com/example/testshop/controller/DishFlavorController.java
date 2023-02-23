package com.example.testshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.common.R;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;
import com.yichen.entity.DishFlavor;
import com.yichen.server.DishFlavorServer;
import com.yichen.server.DishServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishFlavorController {
    @Autowired
    private DishFlavorServer dishFlavorServer;
    @Autowired
    private DishServer dishServer;

//    @GetMapping("/page")
//    public R<Page> page(int page,int pageSize){
//        Page<DishFlavor> pageInfo=new Page<>(page,pageSize);
//        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.orderByDesc(DishFlavor::getName);
//        dishFlavorServer.page(pageInfo,lambdaQueryWrapper);
//        return R.success(pageInfo);
//    }
//    @PostMapping
//    public R<String> add(@RequestBody DishFlavor dishFlavor){
//        dishFlavorServer.save(dishFlavor);
//        return R.success("添加成功");
//    }
}
