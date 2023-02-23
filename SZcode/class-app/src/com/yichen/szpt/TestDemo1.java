package com.yichen.szpt;

import java.util.Arrays;
import java.util.Scanner;

//21区块链1麦立健21190351
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println(testThan(10, 20));
    }

    private static int testThan(int n,int m) {
        if (n==0&m==0) return 0;
        return n>m?n:m;
    }
}
