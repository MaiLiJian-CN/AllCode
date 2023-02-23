package com.Fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        第一步算出FN
        Scanner sc=new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();
        fnValue(num);
    }
    private static void fnValue(long num) {
        long value1= 1;
        long value2=1;
        long value = 0;
        if (num==1||num==2) {
            System.out.println(value1);
            return;
        }
        for (long i = 2; i < num; i++) {
            value=(value1+value2)%10007;
            value2=value1;
            value1=value;
        }
        System.out.println(value);
    }
}
