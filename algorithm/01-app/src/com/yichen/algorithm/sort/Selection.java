package com.yichen.algorithm.sort;

import java.util.Arrays;

public class Selection {

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex=i;
            for (int j = 1+i; j < a.length; j++) {
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            exch(a,i,minIndex);
            System.out.println(Arrays.toString(a));
        }
    }

    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
