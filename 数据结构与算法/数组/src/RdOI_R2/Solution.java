package RdOI_R2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int rs = getNum(num);
        System.out.println(rs*rs);
    }
                              /* x-y               1 */
    public static int getNum(int num){
        if (num==0){
            return 2;
        }
        return 2*getNum(num-1)-1;
    }
}
