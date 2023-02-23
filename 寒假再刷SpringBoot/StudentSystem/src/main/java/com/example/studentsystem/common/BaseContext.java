package com.example.studentsystem.common;

public class BaseContext {
    private static ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();

    public static Integer getCurrentId() {
        return threadLocal.get();
    }

    public static void setCurrentId(Integer id) {
        threadLocal.set(id);
    }
}
