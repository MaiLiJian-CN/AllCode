package com.yichen.threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n){
        this.n=n;
    }


    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i = 1; i < n+1; i++) {
            sum+=i;
        }
        return Thread.currentThread().getName()+"执行1-"+n+"的运算结果:"+sum;
    }
}
