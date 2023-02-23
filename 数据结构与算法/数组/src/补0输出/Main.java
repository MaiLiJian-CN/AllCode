package 补0输出;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] arr={"0000000","000000","00000","0000","000","00","0"};
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            String str = sc.next();
            switch (str.length()){
                case 1:
                    System.out.println(arr[0] + str);
                    break;
                case 2:
                    System.out.println(arr[1] + str);
                    break;
                case 3:
                    System.out.println(arr[2] + str);
                    break;
                case 4:
                    System.out.println(arr[3] + str);
                    break;
                case 5:
                    System.out.println(arr[4] + str);
                    break;
                case 6:
                    System.out.println(arr[5] + str);
                    break;
                case 7:
                    System.out.println(arr[6] + str);
                    break;
                default:
                    System.out.println(str);
                    break;
            }
        }
    }
}
