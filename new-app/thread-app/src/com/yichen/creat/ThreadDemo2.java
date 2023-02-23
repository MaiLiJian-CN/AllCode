package com.yichen.creat;

/**
 * 多线程创建方式二 实现Runnable接口
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建线程任务对象，对象交给Thread
//        new Thread(new MyThread2()).start();
        Runnable r1=new MyThread2();
        Thread t1=new Thread(r1);
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程"+i);
        }
    }
}
//创建线程任务
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+i);
        }
    }
}
