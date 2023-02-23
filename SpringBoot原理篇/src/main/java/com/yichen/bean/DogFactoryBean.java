package com.yichen.bean;

import org.springframework.beans.factory.FactoryBean;

//工厂创建对象
public class DogFactoryBean implements FactoryBean<Dog> {

    /**
     *获取创建bean的对象
     */
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    /**
     *指定获取bean的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    /**
     * 是否单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
