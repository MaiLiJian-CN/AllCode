package com.yichen.api;

/**
 * 给线程名字
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1=new MyThread("子线程一号");
//        t1.setName("子线程一号");
        t1.start();
        System.out.println(t1.getName());
        Thread t2=new MyThread("子线程二号");
//        t2.setName("子线程二号");
        t2.start();
        System.out.println(t2.getName());
        Thread tt=Thread.currentThread();
        System.out.println(tt.getName());
        for (int i = 0; i < 5; i++) {
            System.out.println("main："+i);
        }
    }

}
class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    /**
     * 为当前线程对象设置名称，送给父类构造器初始化名称
     */

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"："+i);
        }
    }
}