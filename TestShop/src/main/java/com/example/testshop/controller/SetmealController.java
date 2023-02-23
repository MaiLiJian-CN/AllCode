package com.example.testshop.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yichen.common.R;
import com.yichen.dto.SetmealDto;
import com.yichen.entity.Category;
import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;
import com.yichen.server.CategoryServer;
import com.yichen.server.SetmealDishServer;
import com.yichen.server.SetmealServer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealServer setmealServer;

    @Autowired
    private CategoryServer categoryServer;

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page<Setmeal> setmealPage=new Page<>(page,pageSize);
        LambdaQueryWrapper<Setmeal> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(name!=null,Setmeal::getName,name);
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealServer.page(setmealPage,queryWrapper);

        Page<SetmealDto> pageInfo=new Page<>();
        BeanUtils.copyProperties(setmealPage,pageInfo,"records");
        List<Setmeal> records = setmealPage.getRecords();
        List<SetmealDto> list = records.stream().map((info)->{
            SetmealDto setmealDto=new SetmealDto();
            BeanUtils.copyProperties(info,setmealDto);
            Long categoryId = info.getCategoryId();
            Category category = categoryServer.getById(categoryId);
            setmealDto.setCategoryName(category.getName());
            return setmealDto;
        }).collect(Collectors.toList());
        pageInfo.setRecords(list);
        return R.success(pageInfo);

    }

    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        setmealServer.saveWithDish(setmealDto);
        return R.success("添加成功");
    }
    @PostMapping("status/0")
    public R<String> stopStatus(@RequestParam List<Long> ids){
        for (Long id : ids) {
            Setmeal setmeal = setmealServer.getById(id);
            setmeal.setStatus(0);
            setmealServer.updateById(setmeal);
        }
        return R.success("下架成功");
    }
    @PostMapping("status/1")
    public R<String> startStatus(@RequestParam List<Long> ids){
        for (Long id : ids) {
            Setmeal setmeal = setmealServer.getById(id);
            setmeal.setStatus(1);
            setmealServer.updateById(setmeal);
        }
        return R.success("下架成功");
    }
    @DeleteMapping
    public R<String> remove(@RequestParam List<Long> ids){
        List<Long> idList=new ArrayList<>();
        for (Long id : ids) {
            Setmeal setmeal = setmealServer.getById(id);
            if (setmeal.getStatus()==0) {
                idList.add(id);
            }
        }
        if (idList.size()==0) return R.error("删除失败");
        idList.forEach((id)->{
            setmealServer.removeById(id);
        });
        return R.success("删除成功");
    }
    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(setmeal.getCategoryId()!=null,Setmeal::getCategoryId,setmeal.getCategoryId());
        wrapper.eq(setmeal.getStatus()!=null,Setmeal::getStatus,1);
        wrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> setmealList = setmealServer.list(wrapper);
        return R.success(setmealList);
    }

}
