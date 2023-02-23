package 分治递归;

public class Main {
    public static void main(String[] args) {
        int[] arr={8,9,1,2,3,0,5,8,4,1};
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int[] arr){
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr,int l,int r){
        if (r==l){
            return arr[r];
        }
        int mid=l+((r-l)>>1);//中点 (l+r)/2 l+(r-l)/2
        int leftMax=process(arr,l,mid);
        int rightMax=process(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }
}
