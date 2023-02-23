package 核酸日期;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int doDay= sc.nextInt(),t= sc.nextInt();
        if (doDay<t){
            System.out.println(t-doDay);
        }else {
            int rs=(7%doDay)+t;
            System.out.println(rs);
        }
    }
}
