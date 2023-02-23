package com.yichen.reflect;

import com.yichen.domain.PersonDemo;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class personDemoClass = PersonDemo.class;
        //getMethod获取方法
        Method eat = personDemoClass.getMethod("eat");
        //involve执行方法，需要有对象
        PersonDemo p1=new PersonDemo();
        eat.invoke(p1);

        Method earMethod2 = personDemoClass.getMethod("eat",String.class);
        earMethod2.invoke(p1,"汉堡");
    }
}
