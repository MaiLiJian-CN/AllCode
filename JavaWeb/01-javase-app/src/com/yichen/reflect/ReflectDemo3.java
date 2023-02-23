package com.yichen.reflect;

import com.yichen.domain.PersonDemo;

import java.lang.reflect.Constructor;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        /**
         * 获取PersonDemo的class对象
         */
        Class personDemoClass= PersonDemo.class;
        /**
         * 获取构造器的方法
         * Constructor<T> getConstructors()
         * Constructor<T> getConstructors(类<T>...parameterTypes)
         * Constructor<T> getDeclaredConstructors
         * Constructor<T> getDeclaredConstructors(类<T>...parameterTypes)
         */
        //Constructor<T> getConstructors(类<T>...parameterTypes)
        Constructor constructor=personDemoClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        Object person = constructor.newInstance("李四", 19);
//        person.setTest("demo3");
        System.out.println(person);

    }
}
