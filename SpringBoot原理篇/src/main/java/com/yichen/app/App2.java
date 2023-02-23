package com.yichen.app;

import com.yichen.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        /*获取配置，打印输出获取的Bean*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext2.xml");

        /*获取配置中的所有bean*/
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }



    }
}
