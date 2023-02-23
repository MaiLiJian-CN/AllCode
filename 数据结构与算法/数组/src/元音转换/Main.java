package 元音转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        String replace = str.replace('a', 'A');
        String replace1 = replace.replace('e', 'E');
        String replace2 = replace1.replace('i', 'I');
        String replace3 = replace2.replace('o', 'O');
        String value = replace3.replace('u', 'U');
        System.out.println(value);
    }
}
