package com.yichen.server.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yichen.common.CustomException;
import com.yichen.common.CustomException;
import com.yichen.entity.Category;
import com.yichen.entity.Dish;
import com.yichen.entity.Setmeal;
import com.yichen.dao.CategoryDao;
import com.yichen.server.CategoryServer;
import com.yichen.server.DishServer;
import com.yichen.server.SetmealServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServerImpl extends ServiceImpl<CategoryDao, Category> implements CategoryServer {
    @Autowired
    private DishServer dishServer;
    @Autowired
    private SetmealServer setmealServer;

    @Override
    public void remove(Long ids) {
      LambdaQueryWrapper<Dish> dishLambdaQueryWrapper=new LambdaQueryWrapper<>();
      dishLambdaQueryWrapper.eq(Dish::getCategoryId,ids);
      int count=dishServer.count(dishLambdaQueryWrapper);
      if (count>0){
          throw new CustomException("当前分类下关联了菜品，不能删除");

      }
//      super.removeById(ids);
      LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper=new LambdaQueryWrapper<>();
      setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,ids);
      int count2=setmealServer.count(setmealLambdaQueryWrapper);
      if (count2>0){
          throw new CustomException("当前分类下关联了套餐，不能删除");
      }
      super.removeById(ids);


    }
}
