package com.yichen.reflect;

import com.yichen.domain.PersonDemo;

public class ReflectDemo1 {
    /**
     *获取Class对象的三种方式
     * 1、Class.forName("类全名")：将字节码文件加载进内存，返回一个Class对象
     * 2、类名.class:通过类名的属性class获取
     * 3、对象.getClass():getClass()方法是在Object类
     */
    public static void main(String[] args) throws Exception{
        //1.Class.forName("类全名")
        Class clas1=Class.forName("com.yichen.domain.PersonDemo");
        System.out.println(clas1);
        //2.类名.class
        Class clas2 = PersonDemo.class;
        System.out.println(clas2);
        //3.对象.getClass()
        PersonDemo p1=new PersonDemo();
        Class clas3 = p1.getClass();
        System.out.println(clas3);
        //比较
        System.out.println(clas1 == clas2);//true
        System.out.println(clas1 == clas2);//true
        /**
         * 同一个字节码文件（*.class）在一次程序运行时，只会被加载一次
         */

    }
}
