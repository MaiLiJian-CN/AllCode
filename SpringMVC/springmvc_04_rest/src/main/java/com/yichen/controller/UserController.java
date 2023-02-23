package com.yichen.controller;

import com.yichen.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
//请求参数
//@Controller
@RestController
@RequestMapping("/users")
public class UserController {
    /*@RequestMapping("/save")
    @ResponseBody
    public String save(){
        System.out.println("user save");
        return "{'module':'user save'}";
    }*/
    //@RequestMapping(value="/users",method = RequestMethod.POST)
    @PostMapping
    public String save(){
        System.out.println("user save");
        return "{'module':'user save'}";
    }

    //@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("user dalete:"+id);
        return "{'module':'user delete'}";
    }

}











