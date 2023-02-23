package RdOI_R2;

import java.util.Scanner;

public class LouTi {
    public static void main(String[] args) {
        System.out.println(getMethods(new Scanner(System.in).nextInt()));
    }
    public static int getMethods(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        return getMethods(n-1)+getMethods(n-2);
    }
}
