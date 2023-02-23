package com.yichen.reflect;

import com.yichen.domain.PersonDemo;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        /**
         * 获取PersonDemo的class对象
         */
        Class c1= PersonDemo.class;
        //Field[] getFields()获取所以public修饰的成员变量
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=======================");
        //Field getField(String name)
        Field a=c1.getField("test");
        //获取成员a变量
        PersonDemo p1=new PersonDemo();
        Object value=a.get(p1);
        System.out.println(value);
        a.set(p1,"张三");
        System.out.println(p1);
        System.out.println("================");
        //Field[] getDeclaredFields(),获取所有的成员变量，不考虑修饰符
        Field[] fields2=c1.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        //Field getDeclaredField(String name)
        Field field=c1.getField("string");
        Object value2=field.get(p1);
        System.out.println(value2);
    }
}
