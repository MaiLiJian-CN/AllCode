package com.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i1 = sc.nextInt();
        int[] s=new int[i1];
        for (int i = 0; i < i1; i++) {
            s[i]=sc.nextInt();
        }
        Arrays.sort(s);
        for (int i : s) {
            System.out.printf("%d\t",i);
        }

    }
}
