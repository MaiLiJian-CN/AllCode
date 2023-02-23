package com.yichen.szpt;

import java.util.ArrayList;
import java.util.Collections;

public class HomeWork3 {
    public static void main(String[] args) {
        int[][] arr=new int[3][3];
        mythood(arr);
    }

    private static void mythood(int[][] arr) {
        int n=11;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j]=n;
                System.out.print(arr[i][j]+" ");
            }
            n+=11;
            System.out.println();
        }

    }
}
