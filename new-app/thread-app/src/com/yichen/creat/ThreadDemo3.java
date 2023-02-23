package com.yichen.creat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程方法三 实现Callable接口
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //创建Callable任务对象
        Callable<String> c1=new MyCallable(3);
        /**
         *将Callable对象交给FutureTask对象
         * FutureTask作用1：是Runnable对象（实现了Runnable接口），可以直接交给Thread;
         * FutureTask作用2：可以在线程执行结束之后调用get()方法获得线程执行完成结果
         */
        FutureTask<String> f1=new FutureTask<>(c1);
        Thread t1=new Thread(f1);
        t1.start();
        try {
            System.out.println(f1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Callable<String> c2=new MyCallable(100);

        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2=new Thread(f2);
        t2.start();
        try {
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/**
 * 实现Callable接口，应该要申明数据类型
 */
class MyCallable implements Callable<String>{
    /**
     *做一个累加数据
     */
    private int n;

    public MyCallable(int n){
        this.n=n;
    }

    int sum;
    @Override
    public String call() throws Exception {
        for (int i = 1; i < n+1; i++) {
            sum+=i;
        }

        return n+"的累计结果是："+sum;
    }
}