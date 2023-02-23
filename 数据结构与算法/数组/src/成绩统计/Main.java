package 成绩统计;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        float num = scan.nextFloat();
        float excellent=0;
        float pass=0;
        float temp=0;
        for (float i = 0; i < num; i++) {
            temp=scan.nextFloat();
            if (temp>=85){
                excellent++;
                pass++;
            }else if (temp>=60){
                pass++;
            }
        }
        scan.close();
        getBate(num,excellent,pass);
    }
    public static void getBate(float total,float excellent,float pass){
        float eBate = excellent / total;
        float pBate=pass/total;
        eBate = Math.round(eBate * 100) / 100f;
        pBate = Math.round(pBate * 100) / 100f;
        NumberFormat format=NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(0);
        System.out.println(format.format(pBate));
        System.out.println(format.format(eBate));
    }

}
