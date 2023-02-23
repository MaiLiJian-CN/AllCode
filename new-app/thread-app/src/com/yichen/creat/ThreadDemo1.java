package com.yichen.creat;

/**
 *多线程的创建方式一 继承Thread类实现
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println("ThreadDemo1:"+i);
        }
        /**
         * 创建线程对象，调用start（）启动
         */
        Thread mt1=new MyThread();
        mt1.start();

//        Thread mt2=new MyThread2();
//        mt2.start();


    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("Mythead:"+i);
        }
    }
}
/**
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("Mythead2:"+i);
        }
    }
}
 */