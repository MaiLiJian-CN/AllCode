package com.yichen.szpt;

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.print("请输入今天星期几：");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        switch (num){
            case 1:
                System.out.println("跑步");
                break;
            case 2:
                System.out.println("游泳");
                break;
            case 3:
                System.out.println("慢走");
                break;
            case 4:
                System.out.println("动感单车");
                break;
            case 5:
                System.out.println("拳击");
                break;
            case 6:
                System.out.println("爬山");
                break;
            case 7:
                System.out.println("好好吃一顿");
                break;
            default:
                System.out.println("你的输入有误");
        }
    }
}
