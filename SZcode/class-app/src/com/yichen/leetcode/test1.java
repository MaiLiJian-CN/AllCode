package com.yichen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3,5, 4, 5, 7, 6, 8};
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        System.out.println(i + 1);


    }
}
