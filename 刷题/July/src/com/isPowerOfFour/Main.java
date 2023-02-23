package com.isPowerOfFour;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1024));
    }
    static boolean isPowerOfFour(int a) {
        // 补充具体实现
        while(a>=4){
            if(a==4){
                return true;
            }
            a=a/4;
        }
        return false;
    }

}
