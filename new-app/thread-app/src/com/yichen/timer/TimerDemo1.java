package com.yichen.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer定时器的使用与了解
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        //创建定时器
        Timer timer=new Timer();//定时器本身就是一个单线程
        //调用方法，处理任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+">鸡汤来咯");
            }
        },3000,2000);
    }
}
