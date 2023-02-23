package com.yichen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.yichen.dao","com.yichen.service"})
public class SpringConfig {
}
