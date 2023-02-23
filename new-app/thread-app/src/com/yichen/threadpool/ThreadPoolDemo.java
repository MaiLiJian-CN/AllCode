package com.yichen.threadpool;

import jdk.jshell.spi.ExecutionControlProvider;

import java.util.concurrent.*;

/**
 * 目标：自定义一个线程对象，并测试其特征
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池对象
        /**
         * public ThreadPoolExecutor(    int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler)
         */
        ExecutorService pool=new ThreadPoolExecutor(3,5,4, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        //给任务线程池处理
        Runnable run=new MyRunnable();

        pool.execute(run);
        pool.execute(run);
        pool.execute(run);

        pool.execute(run);
        pool.execute(run);
        pool.execute(run);
        pool.execute(run);
        pool.execute(run);
//        pool.execute(run);
//        pool.execute(run);
//        pool.execute(run);

    }
}
