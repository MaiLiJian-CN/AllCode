package com.yichen.controller;

import com.yichen.excpet.BusinessException;
import com.yichen.excpet.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ProjectException {
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        System.out.println("打印异常："+e.toString());
        return new Result(null,Code.SYS_UNKNOW_ERR,"系统繁忙");
    }
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        return new Result(null,e.getCode(),e.getMessage());
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        return new Result(null,e.getCode(),e.getMessage());
    }
}
