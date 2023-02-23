package 小秘密;

public class Main {
    public static void main(String[] args) {
        int a=2022;
        StringBuilder str= new StringBuilder();
        while (a > 1) {
            if (a%2==1){
                str.append("1");
            }else {
                str.append("0");
            }
            a/=2;
        }
        str.append(a);
        System.out.println(str.reverse().length());
    }
}