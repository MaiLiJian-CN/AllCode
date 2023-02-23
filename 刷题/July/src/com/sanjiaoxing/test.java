package com.sanjiaoxing;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        sc.close();
        test2(i);
    }
    public static void test2(int n) {
        if (n == 1) {
            System.out.println(1);
        }
        if (n == 2) {
            System.out.println(1);
            System.out.println(1 + " " + 1);
        }else {
            System.out.println(1);
            System.out.println(1 + " " + 1);

            int number = 3;
            while (number <= n) {
                diGUi(number);
                number ++;
            }
        }

    }

    public static void diGUi(int n) {
        for (int i = 1; i <= n; i++) { // 行数

            if (i == 1) {
                System.out.print(1 + " ");
            }else if (i == n) {
                System.out.println(1);
            }else {
                System.out.print(n - 1 + " ");
            }
        }
    }

}