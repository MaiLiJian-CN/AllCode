package Tisheng.GongBeiShu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long num = new Scanner(System.in).nextLong();
        if (num%2!=0){
            System.out.println(num*(num-1)*(num-2));
        }else if (num%3!=0){
            System.out.println(num*(num-1)*(num-3));
        }else {
            System.out.println((num-1)*(num-2)*(num-3));
        }
    }
}
