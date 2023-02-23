package com.moveZero;

public class Main {
    public static void main(String[] args) {
        moveZero(new int[]{0,0,1,2,0,0,1,3});
    }
    /*
    * 0,1,0,0,1,2,3,4,0  index=8开始
    *                       change=0
    *                    index=3
    *        0 1 0 1 2 3  4 0 0
    * */
    public static void moveZero(int[] nums){
        /*遍历看看多少个0*/
        int count=0;
        int num = nums.length - 1;
        for (int i = num; i>=0; i--) {
            count++;
            if (nums[i]==0){
                for (int j = 0; j < count; j++) {
                    if (i+j==num) {
                        nums[i+j]=0;
                        break;
                    }else {
                    nums[i+j]=nums[i+j+1];
                    }
                }
            }
        }
        for (int i : nums) {
            System.out.print(i+"\t");
        }


    }
}
