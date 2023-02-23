package com.DexHex;

import java.util.Scanner;

public class Main {
    public static char[] map = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();
        System.out.println(toHex(num));
    }

    public static String toHex(Long number) {
        if (number==0) return "0";
        int n;
        StringBuilder result= new StringBuilder();
        while (true){
            if (number<16){
                result.append(map[Math.toIntExact(number)]);
                return result.reverse().toString();
            }
            n= Math.toIntExact(number % 16);
            result.append(map[n]);
            number/=16;
        }
    }
}
