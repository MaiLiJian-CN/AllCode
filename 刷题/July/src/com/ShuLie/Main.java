package com.ShuLie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();//个数
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        sc.close();
        findIndex(find,arr);
    }

    private static void findIndex(int find, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (find==arr[i]){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(-1);
    }
}
