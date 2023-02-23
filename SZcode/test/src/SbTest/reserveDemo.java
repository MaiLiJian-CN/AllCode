package SbTest;

public class reserveDemo {
    public static void main(String[] args) {
        String s="abc";
        String s1 = sbReverse(s);
        System.out.println(s1);
    }

    public static String sbReverse(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
