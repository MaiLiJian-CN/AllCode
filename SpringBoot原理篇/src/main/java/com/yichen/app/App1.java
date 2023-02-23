package com.yichen.app;

import com.yichen.bean.Dog;
import javafx.application.Application;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        /*获取配置，打印输出获取的Bean*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext1.xml");
        Object cat = ctx.getBean("cat");
        System.out.println(cat);

        /*不配置id也能调用*/
        Dog dog = ctx.getBean(Dog.class);
        System.out.println(dog);

        /*获取配置中的所有bean*/
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }



    }
}
