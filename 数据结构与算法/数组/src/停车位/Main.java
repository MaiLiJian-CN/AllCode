package 停车位;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int l = sc.nextInt(),k = sc.nextInt(),n = sc.nextInt();
            int[] arr=new int[n];
            int ans=0,last=0,a=0;
            for (int i = 0; i < n; i++) {
                a= sc.nextInt();
                ans+=(a-last-1)/k;
                last=a;
            }
            ans+=(l-last)/k;
            System.out.println(ans);
        }
    }
}
