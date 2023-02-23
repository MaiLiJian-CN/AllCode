package com.example.testshop.common;

public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new InheritableThreadLocal<>();

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
}
