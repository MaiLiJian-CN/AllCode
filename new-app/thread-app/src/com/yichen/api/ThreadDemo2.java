package com.yichen.api;

/**
 * 休眠API
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            /**
             * 静态方法直接调用类名
             */
            if (i==5) Thread.sleep(5000);
        }
    }
}
