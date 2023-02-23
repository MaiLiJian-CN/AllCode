package com.Zimu;

import java.util.Scanner;

public class function {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        int i1 = sc.nextInt();
        function(i,i1);
    }
    public static void function(int n, int m) {
        String[] list = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] lastList = new String[m];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(list[i]);
                lastList[i] = list[i];
                for (int k = 1; k < m; k++) {
                    if (k == m - 1) {
                        System.out.println(list[k]);
                    }else {
                        System.out.print(list[k]);
                        lastList[k] = list[k];
                    }
                }
            }else {
                String[] lastList2 = new String[m];
                System.out.print(list[i]);
                lastList2[0] = list[i];
                for (int j = 0; j < lastList.length-1; j++) { // BABCDE 5
                    if (j == lastList.length - 2) {
                        System.out.println(lastList[j]);
                        lastList2[j+1] = lastList[j];
                    }else {
                        System.out.print(lastList[j]);
                        lastList2[j+1] = lastList[j]; // BABCDE
                    }
                }
                for (int j = 0; j < m; j++) {
                    lastList[j] = lastList2[j];
                }
            }
        }
    }
}
