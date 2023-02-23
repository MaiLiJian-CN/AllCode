package com.example.testshop.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLClientInfoException;
import java.sql.SQLIntegrityConstraintViolationException;

@ResponseBody
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException e){
        log.error(e.getMessage());
        if (e.getMessage().contains("Duplicate")){
            String[] msg=e.getMessage().split(" ");
            return R.error(msg[2]+"已存在");
        }
        return     R.error("报错");

    }
}
