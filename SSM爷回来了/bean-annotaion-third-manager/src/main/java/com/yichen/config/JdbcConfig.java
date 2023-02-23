package com.yichen.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yichen.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.url}")
    private String usl;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String passwd;
    @Value("${jdbc.driver}")
    private String driver;

    @Bean
    public DruidDataSource dataSource(BookDao bookDao){
        System.out.println(bookDao);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(usl);
        dataSource.setUsername(name);
        dataSource.setPassword(passwd);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
