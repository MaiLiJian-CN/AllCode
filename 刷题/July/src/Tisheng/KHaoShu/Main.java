package Tisheng.KHaoShu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k = sc.nextInt();
        int l = sc.nextInt();
        sc.close();
        getNumberOfKGood(k,l);
    }
    /*
    * L\k	0	1	2	3
        1	0	1	1	1
        2	2	2	1	2
        3	5	4	3	6
        4	14	10	8	15
    * */
    private static void getNumberOfKGood(int k, int l) {
        int[][] arr= new int[l][k];
        for (int i = 1; i < k; i++) {
            arr[0][i]=1;
        }
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < k; j++) {
                for (int m = 0; m < k; m++) {
                    if ((j!=m+1)&&(j!=m-1)){
                        arr[i][j]=(arr[i][j]+arr[i-1][m])%1000000007;
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=arr[l-1][i];
        }
        System.out.println(sum%1000000007);
    }
}

