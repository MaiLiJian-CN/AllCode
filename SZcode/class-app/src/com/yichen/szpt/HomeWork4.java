package com.yichen.szpt;

import javax.annotation.processing.Completion;
import java.util.ArrayList;
import java.util.Collections;

public class HomeWork4 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        Integer[] rs_list = method(arr);
        System.out.println("MAX:"+rs_list[0]);
        System.out.println("MIN:"+rs_list[1]);
    }

    private static Integer[] method(int[] arr) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        Integer[] arr2= new Integer[2];
        for (int i : arr) {
            arrayList.add(i);
        }
        arr2[0]= Collections.max(arrayList);
        arr2[1]= Collections.min(arrayList);
        return arr2;
    }
}
