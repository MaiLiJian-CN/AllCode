package com.example.backend.controller;
import com.example.common.constant.MessageConstant;
import com.example.common.entity.Result;
import com.example.common.pojo.CheckItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 体检检查项管理
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        System.out.println("checkItem:"+checkItem.toString());
        try {
        }catch (Exception e){
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

}