package com.Zimu;
import java.util.Scanner;

public class Main {
    static char[] words= new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row = sc.nextInt();//行
        int cow = sc.nextInt();//列
        StringBuilder str=new StringBuilder();
        StringBuilder pln=new StringBuilder();
        sc.close();
        /*添加字母*/
        for (int i = 0; i < cow; i++) {
            str.append(words[i]);//{a,b,c,d}
        }
        if (row!=1){
            for (int i = 0; i < row; i++) {
                pln.insert(0,words[i]);
                pln.delete(pln.length()-1,pln.length());
                pln.append(str.substring(pln.length(),str.length()));
                System.out.println(pln);

            }
        }else {
            System.out.println(str);
        }

    }


}
