package com.yichen.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService创建定时器
 */
public class TimerDemo2 {
    public static void main(String[] args) throws Exception{
        //创建ScheduledExecutorService线程池
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(3);

        //开启定时任务
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行输出hhh");
            }
        },1,2, TimeUnit.SECONDS);


    }
}
