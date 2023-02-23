package com.yichen.creat;

/**
 * 创建多线程方式二（2）Rnnable匿名内部类
 */
public class ThreadDemo2Other {
    public static void main(String[] args) {
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程1："+i);
                }
            }
        };
        Thread t1=new Thread(r1);
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2："+i);
                }
            }
        });

        new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程3："+i);
                }}).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程："+i);
        }
    }
}
