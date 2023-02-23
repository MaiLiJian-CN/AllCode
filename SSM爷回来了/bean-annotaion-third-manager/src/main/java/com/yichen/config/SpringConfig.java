package com.yichen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.yichen.dao")
@Import({JdbcConfig.class})
public class SpringConfig {
}
