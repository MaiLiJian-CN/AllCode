package com.example.mybatisdemo1;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/example/mybatisdemo1/mapper")
public class MyBatisDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemo1Application.class, args);
    }

}
