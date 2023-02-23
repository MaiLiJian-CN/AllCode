package com.yichen;

import com.yichen.config.SpringConfig;
import com.yichen.dao.ResourcesDao;
import com.yichen.service.ResourcesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourcesService resourcesService = ctx.getBean(ResourcesService.class);
        boolean flag = resourcesService.openURL("https://baidu.com", "root ");
        System.out.println(flag);
    }
}
