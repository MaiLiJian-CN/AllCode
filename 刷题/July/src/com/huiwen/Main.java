package com.huiwen;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        for (int i = 10000; i <=999999 ; i++) {
            int value = GetValue(i);
            Boolean rs  = GetStr(i);
            if (value==num&&rs){
                System.out.println(i);
            }
        }
    }

    public static Boolean GetStr(int temp){
        String v=""+temp;
        StringBuilder str= new StringBuilder();
        for (int i = v.length()-1; i >=0; i--) {
            str.append(v.charAt(i));
        }
        return str.toString().equals(v);
    }

    public static int GetValue(int temp){
        String value=""+temp;
        int num=0;
        for (int i = 0; i < value.length(); i++) {
            num+=Integer.parseInt(String.valueOf(value.charAt(i)));
        }
        return num;
    }
}
