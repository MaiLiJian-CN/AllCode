package com.yichen.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
/*效果等同@Component都是为了让SpringBoot扫描*/
public class DbConfig {

    @Bean
    /*生产一个Bean对象为了交给springboot管理*/
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
