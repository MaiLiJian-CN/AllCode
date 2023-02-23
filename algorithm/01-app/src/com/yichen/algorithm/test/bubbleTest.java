package com.yichen.algorithm.test;

import com.yichen.algorithm.sort.Bubble;

import java.util.Arrays;

public class bubbleTest {
    public static void main(String[] args) {
        Integer[] arr={4,5,6,3,2,1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
