package 成绩分析;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static float rs=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int[] arr=new int[row];
        for (int i = 0; i < row; i++) {
            arr[i]=scan.nextInt();
        }
        for (int i : arr) {
            rs+=i;
        }
        int max = getMax(arr, 0, arr.length - 1);
        int min = getMin(arr, 0, arr.length - 1);
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f",rs/arr.length);
        scan.close();
    }
    public static int getMax(int[] arr,int l,int r){
        if (l==r) return arr[l];
        int mid=l+((r-l)>>1);
        int leftMax=getMax(arr,l,mid);
        int rightMax=getMax(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }
    public static int getMin(int[] arr,int l,int r){
        if (r==l) return arr[r];
        int mid=l+((r-l)>>1);
        int leftMin=getMin(arr,l,mid);
        int rightMin=getMin(arr,mid+1,r);
        return Math.min(leftMin,rightMin);
    }
}
