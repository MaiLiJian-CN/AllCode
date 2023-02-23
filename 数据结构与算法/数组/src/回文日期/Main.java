package 回文日期;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt();

        String circle = getCircle(data);
        System.out.println(circle);
        System.out.println(getAB(circle));
        scan.close();
    }



    private static String getCircle(int value) {

        while (true){
            value+=1;
            String data =String.valueOf(value);

            int years = Integer.parseInt(data.substring(0, 4));
            int mouths= Integer.parseInt(data.substring(4, 6));
            int days = Integer.parseInt(data.substring(6, 8));
            if (1000<=years&&8999>=years&&mouths>=1&&mouths<=12&&days>0&&days<32) {
                if (
                        String.valueOf(value).substring(0, 1).equals(String.valueOf(value).substring(7, 8)) &&
                                String.valueOf(value).substring(1, 2).equals(String.valueOf(value).substring(6, 7)) &&
                                String.valueOf(value).substring(2, 3).equals(String.valueOf(value).substring(5, 6)) &&
                                String.valueOf(value).substring(3, 4).equals(String.valueOf(value).substring(4, 5))
                ) {
                    return String.valueOf(value);
                }
            }
        }
    }
    public static String getAB(String data){
        while (true){
            if (data.substring(0,2).equals(data.substring(2,4))){
                return data;
            }
            data=getCircle(Integer.parseInt(data));
        }

    }

}