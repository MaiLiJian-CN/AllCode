package 排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] arr=new char[26];
        for (int i = 25; i > 0; i--) {
            arr[i]= (char) (97+i);
        }

        getRs(arr,0,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

    private static int getRs(char[] arr, int l, int r,int rs) {
        if (rs==100) return rs;
        if (arr[l++] > arr[r]){
            rs++;
        }
        return getRs(arr,l,r,rs);
    }

}
