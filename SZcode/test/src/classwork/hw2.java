package classwork;

public class hw2 {
    public static void main(String[] args) {
        int[] arr={19,28,37,46,50};
        int[] arr2=new int[arr.length];
        int j=0;
        for (int i = arr.length-1; i >=0; i--) {
            arr2[j]=arr[i];
            j+=1;
        }
        for (int i : arr2) {
            System.out.println(i);
        }
    }
}
