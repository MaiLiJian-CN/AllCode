package com.yichen;


import com.yichen.config.SpringConfig;
import com.yichen.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SMApp11 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = ctx.getBean("AccountService", AccountService.class);
        service.findAll().forEach(System.out::println);
    }
}
