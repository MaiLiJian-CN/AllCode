package com.yichen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.yichen")
@Import({JdbcConfig.class,MybatisConfig.class})
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
}

