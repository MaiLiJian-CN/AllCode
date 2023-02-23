package com.LeiJia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String num = new Scanner(System.in).next();
        sum(num);
    }

    private static void sum(String num) {
        long end=0;
        long value = Long.parseLong(num);
        for (int i = 1; i <= value; i++) {
            end+=i;
        }
        System.out.println(end);
    }
}
