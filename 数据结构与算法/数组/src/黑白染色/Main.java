package 黑白染色;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            Long rs=0L;
            Long n= sc.nextLong(),m= sc.nextLong();
            if (m%2==0){
                rs= n*m/2;
            }else {
                long floor = (long) Math.floor(m * 1.0 / 2);
                long ceil = (long) Math.ceil(n * 1.0 / 2);
                rs =(n*floor)+ceil;
            }
            System.out.println(rs);
        }
        sc.close();
    }

}
