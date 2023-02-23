package com.yichen;


import com.yichen.config.SpringConfig;
import com.yichen.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App13 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = ctx.getBean("AccountService", AccountService.class);

    }
}
