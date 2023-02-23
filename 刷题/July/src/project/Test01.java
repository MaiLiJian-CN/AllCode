package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
* 题目

实现一个 36 进制的加法 0-9 a-z。

示例

输入：["abbbb","1"]，输出："abbbc"
* */
public class Test01 {
    public static char[] chars=new char[26];
    public static String[] strArr=new String[36];
    public static int[] intArr=new int[36];
    static {
        for (int i = 0; i < 26; i++) {
            chars[i]= (char) ('a'+i);
        }
        for (int i = 0; i <36; i++) {
            intArr[i]=i;
            if (i>=10){
             strArr[i]=String.valueOf(chars[i-10]);
            }else {
                strArr[i]=String.valueOf(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strings={"abbbb","1"};
        scanner.close();
        ArrayList<Long> arrayList=new ArrayList<>();
        for (String string : strings) {
            long dec =Long.parseLong(To36dec(string));//返回数值
            arrayList.add(dec);
        }
        Long num=0L;
        for (Long aLong : arrayList) {
            num+=aLong;
        }
        System.out.println(decTo36(num));

    }
    public static String To36dec(String str){
        StringBuilder sb=new StringBuilder(str).reverse();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(sb.charAt(i));
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals(c)){
                    arr.add(intArr[j]);
                }
            }
        }
        long num=0;
        for (int i = 0; i < arr.size(); i++) {
            num += (long) (arr.get(i) * Math.pow(36, i));
        }
        return String.valueOf(num);
    }
    public static String decTo36(long num){
        ArrayList<Integer> arr=new ArrayList<>();
        while (num>36){
            int temp= (int) (num%36);
            arr.add(temp);
            num/=36;
        }
        arr.add((int)num);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            String s = strArr[arr.get(i)];
            sb.append(s);
        }
        return String.valueOf(sb.reverse());
    }

}
