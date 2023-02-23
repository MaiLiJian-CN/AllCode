package com.yichen.app;

import com.yichen.bean.Dog;
import com.yichen.config.SpringConfig3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {
    public static void main(String[] args) {
        /*获取配置，打印输出获取的Bean*/
//        ApplicationContext ctx=new ClassPathXmlApplicationContext(SpringConfig3.class);只能加载配置文件
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig3.class);//使用该方法，SpringConfig3本身也会变成一个bean
        /*获取配置中的所有bean*/
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }



    }
}
