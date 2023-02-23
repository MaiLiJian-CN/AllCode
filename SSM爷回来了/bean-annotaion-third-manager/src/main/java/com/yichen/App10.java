package com.yichen;

import com.alibaba.druid.pool.DruidDataSource;
import com.yichen.config.JdbcConfig;
import com.yichen.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App10 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
        System.out.println(dataSource.getUsername());
        System.out.println(dataSource.getPassword());
    }
}
