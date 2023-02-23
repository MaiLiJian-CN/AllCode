package com.yichen.szpt;

import java.util.Random;
import java.util.Scanner;

public class randomTest {

    public static void main(String[] args) {
        testPrint(20,40);
    }

    private static void testPrint(int n,int m) {
        for (int i = 0; i < (m-n+1); i++) {
            int num=i+n;
            if (num%2!=0) System.out.println(num);
        }
    }

}
