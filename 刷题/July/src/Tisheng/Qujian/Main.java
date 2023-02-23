package Tisheng.Qujian;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len = sc.nextInt();//序列长度
        Integer[] arr=new Integer[len];//循环赋予序列个数值
        for (int i = 0; i < len; i++) {
            arr[i]=sc.nextInt();
        }
        int num = sc.nextInt();//询问个数
        method(sc,arr,num);
        sc.close();
    }

    private static void method(Scanner sc, Integer[] arr, int num) {
        Integer[][] inputArr=new Integer[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                inputArr[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < num; i++) {
            Integer[] v=new Integer[inputArr[i][1]-inputArr[i][0]+1];
            for (int j = 0; j < v.length; j++) {
                v[j] = arr[inputArr[i][0] - 1+j];
            }
            Arrays.sort(v,Collections.reverseOrder());
            System.out.println(v[inputArr[i][2]-1]);
        }
    }
}
