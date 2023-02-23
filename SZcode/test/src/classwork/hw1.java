package classwork;

import java.util.Scanner;

public class hw1 {
    public static void main(String[] args) {
        int[][] arr=new int[4][3];
        Scanner sc=new Scanner(System.in);
        int[][] total = total(arr, sc);
        calcTotal(total);
    }

    private static void calcTotal(int[][] total) {
        for (int i = 0; i < total.length; i++) {
            int sum=0;
            for (int j = 0; j < total[i].length; j++) {
                sum+=total[i][j];
            }
            System.out.println("第"+(i+1)+"季度总营业额为："+sum);
        }
    }

    private static int[][] total(int[][] arr,Scanner sc) {
        for (int i = 0; i < arr.length; i++) {
              String[] string = sc.nextLine().split(" ");
            for (int j = 0; j < string.length; j++) {
                arr[i][j]= Integer.parseInt(string[j]);
            }

        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        return arr;
    }
}
