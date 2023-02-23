package com.yichen.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executors的工具方法得到一个新线程
 */
public class ThreadPoolDemo3 {
    public static void main(String[] args) throws Exception{
        //创建固定线程数据的线程池
        ExecutorService pool= Executors.newFixedThreadPool(3);

        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
    }
}
