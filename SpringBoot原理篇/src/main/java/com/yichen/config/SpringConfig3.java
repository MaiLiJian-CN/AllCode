package com.yichen.config;

import com.yichen.bean.Dog;
import com.yichen.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.yichen.bean","com.yichen.config"})
@Configuration
/*等同于<context:component-scan base-package="com.yichen.bean,com.yichen.config"/>*/
public class SpringConfig3 {
    /*该类效果等于
    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">
       */
    @Bean
    public Dog dog(){
        return new Dog();
    }
    @Bean
    public DogFactoryBean dogTwo(){
        return new DogFactoryBean();
    }
}
