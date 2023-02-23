package students;

import java.util.Locale;
import java.util.Scanner;

public class StrDemo {
    public static void main(String[] args) {
        /**
         char[] chars={'a','b','c'};
         String s1=new String(chars);
         String s2=new String(chars);
         System.out.println(s1);
         System.out.println(s2);
         System.out.println(s1==s2);
         System.out.println(s1.equals(s2));*/
        /**
         char[] chars={'a','b','c'};
         char[] chars2={'a','B','c'};
         String s1=new String(chars);
         String s2=new String(chars2);
         System.out.println(s1);
         System.out.println(s2);
         System.out.println(s1==s2);
         System.out.println(s1.equalsIgnoreCase(s2));
         */
        /**
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num=0;
        int num2=0;
        int num3=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='0' && s.charAt(i)<='9') num+=1;
            else if (s.charAt(i)>='a' && s.charAt(i)<='z') num2+=1;
            else if (s.charAt(i)>='A' && s.charAt(i)<='Z') num3+=1;
        }
        System.out.println("小写："+num2);
        System.out.println("大写："+num3);
        System.out.println("数字："+num);*/
        Scanner sc=new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        for (String s1 : s) {
            System.out.println(s1);
        }

    }


}
