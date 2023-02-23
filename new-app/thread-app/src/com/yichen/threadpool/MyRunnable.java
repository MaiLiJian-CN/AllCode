package com.yichen.threadpool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"输出：Hello World>"+i);
        }
        try {
            System.out.println(Thread.currentThread().getName()+"进行休眠");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
