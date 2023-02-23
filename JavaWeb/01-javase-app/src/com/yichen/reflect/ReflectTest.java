package com.yichen.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    /**
     * 搭建“框架”类
     */
    public static void main(String[] args) throws Exception{
        //创建pro对象
        Properties pro=new Properties();
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is=classLoader.getResourceAsStream("pro.properties");
        //加载配置文件，转换为集合
        pro.load(is);

        //获取配置文件中定义的数据
        String className= pro.getProperty("className");
        String methodName= pro.getProperty("methodName");

        //加载该类进内存
        Class clas = Class.forName(className);
        //创建对象
        Object obj = clas.getDeclaredConstructor().newInstance();
        //调用方法
        Method method = clas.getMethod(methodName);
        method.invoke(clas);

    }
}
