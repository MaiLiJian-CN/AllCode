package com.yichen.threadpool;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {
    public static void main(String[] args) throws Exception{
        ExecutorService pool=new ThreadPoolExecutor(3,4,6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Future<String> f1=pool.submit(new MyCallable(10));
        Future<String> f2=pool.submit(new MyCallable(20));
        Future<String> f3=pool.submit(new MyCallable(30));
        Future<String> f4=pool.submit(new MyCallable(40));
        Future<String> f5=pool.submit(new MyCallable(50));

//        String s1=f1.get();
//        System.out.println(s1);
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
        pool.shutdown();
    }
}
