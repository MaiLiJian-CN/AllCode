package 选择排序;

public class SelectionSort {
    public static void swapElements(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int indexLowest(int[] arr,int start){
        int lowIndex=start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i]<arr[lowIndex]){
                lowIndex=i;
            }
        }
        return lowIndex;
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int j = indexLowest(arr, i);
            swapElements(arr,i,j);
        }
    }
}
