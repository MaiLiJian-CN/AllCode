package com.yichen.api;

public class DrawDemo extends Thread{
    private Account acc;
    public DrawDemo(Account acc,String name){
        super(name);
        this.acc=acc;
    }

    @Override
    public void run() {
        //取钱操作
        acc.drawMoney(10000);
    }
}
