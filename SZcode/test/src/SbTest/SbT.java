package SbTest;

public class SbT {
    public static void main(String[] args) {
//        StringBuilder sb= new StringBuilder();
//        System.out.println(sb.length());
//        StringBuilder sb2= new StringBuilder("123");
//        System.out.println(sb2);

          StringBuilder sb=new StringBuilder();
          sb.append("szpt");
          sb.append("world");
          sb.append(100);
//        System.out.println(sb);
//        System.out.println(sb.reverse());
         String s1=new String(sb);
         StringBuilder sb2=new StringBuilder(s1);
        System.out.println(s1);
        System.out.println(sb2);
    }
}
