package com.yichen.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.common.R;
import com.yichen.dto.DishDto;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;
import com.yichen.entity.DishFlavor;
import com.yichen.server.CategoryServer;
import com.yichen.server.DishFlavorServer;
import com.yichen.server.DishServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishServer dishServer;

    @Autowired
    private DishFlavorServer dishFlavorServer;

    @Autowired
    private CategoryServer categoryServer;

    @PostMapping("")
    public R<String> save(@RequestBody DishDto dishDto){
        dishServer.saveWithFlavor(dishDto);
        return R.success("添加成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page<Dish> pageInfo=new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage=new Page<>();
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Dish::getName,name);
        queryWrapper.orderByDesc(Dish::getUpdateTime);
        dishServer.page(pageInfo,queryWrapper);

        BeanUtils.copyProperties(pageInfo,dishDtoPage,"records");

        List<Dish> records = pageInfo.getRecords();
        List<DishDto> dishDtos= records.stream().map((food)->{
            DishDto dishDto=new DishDto();
            BeanUtils.copyProperties(food,dishDto);
            Long categoryId = food.getCategoryId();
            Category category = categoryServer.getById(categoryId);
            String name1 = category.getName();
            dishDto.setCategoryName(name1);
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(dishDtos);
        return R.success(dishDtoPage);
    }

    @GetMapping("/{id}")
    public R<DishDto> get(@PathVariable Long id){
        DishDto dishDto = dishServer.getByIdWithFlavor(id);
        return R.success(dishDto);
    }

    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){

        dishServer.updateWithFlavor(dishDto);
        return R.success("修改成功");
    }

    @PostMapping("/status/0")
    @Transactional
    public  R<String> stopStatus(@RequestParam List<Long> ids){
        for (Long id : ids) {
            Dish dish = dishServer.getById(id);
            dish.setStatus(0);
            dishServer.updateById(dish);
        }
        return R.success("下架成功");
    }

    @PostMapping("/status/1")
    @Transactional
    public  R<String> startStatus(@RequestParam List<Long> ids){
        for (Long id : ids) {
            Dish dish = dishServer.getById(id);
            dish.setStatus(1);
            dishServer.updateById(dish);
        }
        return R.success("上架成功");
    }


    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids){
        List<Long> IdsEnd=new ArrayList<>();
        for (Long id : ids) {
            Dish dish = dishServer.getById(id);
            if (dish.getStatus()==0){
                IdsEnd.add(id);
            }
        }
        if (IdsEnd.size()==0) return R.error("删除失败");
        for (Long id : IdsEnd) {
            LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(id!=null,Dish::getId,id);
            dishServer.remove(queryWrapper);
        }
        return R.success("删除成功");
    }

    /*@GetMapping("/list")
    public R<List<Dish>> list(Dish dish){
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus,1);
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list=dishServer.list(queryWrapper);
        return R.success(list);
    }*/
    @GetMapping("/list")
    public R<List<DishDto>> list(Dish dish){
        LambdaQueryWrapper<Dish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        queryWrapper.eq(Dish::getStatus,1);
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list=dishServer.list(queryWrapper);
        List<DishDto> dishDtoList=list.stream().map((info)->{
            DishDto dishDto=new DishDto();
            BeanUtils.copyProperties(info,dishDto);
            Long id = info.getCategoryId();
            Category category = categoryServer.getById(id);
            if (category!=null){
                String name = category.getName();
                dishDto.setCategoryName(name);
            }
            Long dishID = info.getId();
            LambdaQueryWrapper<DishFlavor> wrapper=new LambdaQueryWrapper<>();
            wrapper.eq(DishFlavor::getDishId,dishID);
            List<DishFlavor> dishFlavors = dishFlavorServer.list(wrapper);
            dishDto.setFlavors(dishFlavors);

            return dishDto;
        }).collect(Collectors.toList());
        return R.success(dishDtoList);
    }


}
