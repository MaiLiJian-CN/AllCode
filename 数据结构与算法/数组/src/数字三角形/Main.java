package 数字三角形;

import java.util.Arrays;
import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();//行数
        boolean[][] booleans = new boolean[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                booleans[i][j] = false;
            }
        /*int[][] arr=new int[row][row];
        int[][] dp=new int[row][row];
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <=i; j++) {
                arr[i][j]=sc.nextInt();
            }
        }*/
            sc.close();
        }

    }

}