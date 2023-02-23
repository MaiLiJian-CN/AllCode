package 数递增三元组;

public class Main {
    public static int[] arr={2,9,17,4,14,10,25,26,11,14,16,17,14,21,16,27,32,20,26,36};
    public static void main(String[] args) {
        int n=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i<j&&j<k){
                        if (arr[i]<arr[j]&&arr[j]<arr[k]){
                            n++;
                        }
                    }
                }
            }
        }
        System.out.println(n);
    }
}
