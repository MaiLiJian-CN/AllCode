package 字符串移动;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
while (sc.hasNextInt()){
    int num = sc.nextInt();
    String srt = sc.next();
    System.out.println(getOld(num, srt)+getMove(num, srt));
}
    }

    public static String getMove(int num,String str){
        String move="";
        for (int i = 0; i < str.length()-num%str.length(); i++) {
            move+=str.charAt(i);
        }
        return move;
    }
    public static String getOld(int num,String str){
        String old="";
        for (int i = str.length()-num%str.length(); i < str.length(); i++) {
            old+=str.charAt(i);
        }
        return old;
    }
}
