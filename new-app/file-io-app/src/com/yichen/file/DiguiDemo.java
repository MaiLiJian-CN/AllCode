package com.yichen.file;

public class DiguiDemo {
    public static void main(String[] args) {
        System.out.println(f(5));
        System.out.println(peace(1));
    }

    private static int f(int num) {
        if (num==1){
            return 1;
        }else {
            return f(num-1)+num;
        }
    }


    /**
     * f(x)-[f(x)/2+1]=f(x+1)
     * 2f(x)-f(x)-2=2f(x+1)
     * f(x)=2f(x+1)+2
     */
    public static int peace(int n){
        if (n==10) return 1;
        return 2*peace(n+1)+2;
    }
}
