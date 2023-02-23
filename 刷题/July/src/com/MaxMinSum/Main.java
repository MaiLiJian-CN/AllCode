package com.MaxMinSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr=new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        max(arr);
    }

    private static void max(int[] arr) {
        int max=arr[0];
        int min=arr[0];
        int sum=arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum+=arr[i];
            if (max<arr[i]) max=arr[i];
            if (min>arr[i]) min=arr[i];
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
    }
}
