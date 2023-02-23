package 选择排序;

import java.util.Arrays;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] arr={2,1,3,5,8,2,10};
        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
