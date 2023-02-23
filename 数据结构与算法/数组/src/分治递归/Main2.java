package 分治递归;

import java.util.Arrays;

public class Main2 {
    public static void merge(int[] arr,int l,int m,int r){
        int[] help=new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=m+1;
        while (p1<=m&&p2<=r){
            help[i++]=arr[p1]<=arr[p2]?arr[p1++] :arr[p2++];
        }
        while (p1<=m){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j+l]=help[j];
        }
    }
    public static void process(int[] arr,int l,int r){
        if (l==r) {
            return;
        }
        int mid=l+((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void main(String[] args) {
        int[] arr={1,0,4,2,5,7};
        process(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
