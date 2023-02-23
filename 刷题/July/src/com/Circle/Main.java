package com.Circle;

import java.util.Scanner;

public class Main {
    private static final double Pi=3.14159265358979323;
    public static void main(String[] args) {
        double r = new Scanner(System.in).nextDouble();
        r=(r*r)*Pi;
        System.out.printf("%.7f",r);
    }
}
