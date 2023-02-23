package 比正整数大的数;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            String nextLine = sc.nextLine();
            int x = sc.nextInt();
            getNum(nextLine,x);
        }
    }

    private static void getNum(String nextLine,Integer x) {
        String[] split = nextLine.split(" ");
        Integer[] num=new Integer[split.length];
        for (int i = 0; i < split.length; i++) {
            num[i]=Integer.parseInt(split[i]);
        }
        Arrays.sort(num);
        int index=0;
        for (int i = 0; i < num.length; i++) {
            if (Objects.equals(x, num[i])){
                index=i;
                break;
            }
        }
        for (int i = 1; i <= num.length-1 - index; i++) {
            System.out.printf("%d ",num[index+i]);
        }
        System.out.println();
        System.out.println(num.length-index-1);
    }
}
