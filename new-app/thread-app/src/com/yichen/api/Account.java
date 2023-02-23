package com.yichen.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private String cardId;
    private double money;

    private final Lock lock=new ReentrantLock();

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public Account() {
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public void drawMoney(double money) {
        //判断取钱用户
        String name=Thread.currentThread().getName();
        //判断余额是否充足
        lock.lock();
        try {
            if (this.money>=money){
                //开始取钱
                System.out.println(name+"取出"+money);

                //更新存款
                this.money-=money;
                System.out.println(name+"取出，剩余:"+this.money);
            }else {
                System.out.println(name+"取钱，但余额不足");
            }
        } finally {
            lock.unlock();
        }


    }
}
