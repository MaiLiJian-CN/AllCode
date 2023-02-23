package com.sanjiaoxing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        sc.close();
        method(count);
    }
    public static void method( int count){
        int[][] arr=new int[count][count];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <=i ; j++) {
                if (j==0||j==i){
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

/*
    public static void method2(int count){
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(method2_2(i, j)+"\t");
            }
            System.out.println();
        }
    }
    */
/*行数和列数*//*

    public static int method2_2(int num1,int num2){
        if (num2==1||num1==num2){
            return 1;
        }else {
            return method2_2(num1-1,num2-1)+method2_2(num1-1,num2);
        }
    }
*/

}
