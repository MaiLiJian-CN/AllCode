package com.yichen.szpt;

import java.util.Scanner;

public class PingWei {
    public static void main(String[] args) {
        int[] score=new int[6];
        int max=0;
        int min=100;
        int average=0;
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < score.length; i++) {
            System.out.println("请输入第"+(i+1)+"评委的分数：");
            score[i] = sc.nextInt();
        }
        for (int i : score) {
            if (i>=max) max=i;
            if (i<=min) min=i;
        }
        for (int i : score) {
            average+=i;
        }
        System.out.println("最大值："+max+" 最小值："+min);
        System.out.println("平均值为："+(average - max - min) / (score.length - 2));
    }
}
