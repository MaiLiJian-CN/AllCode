package students;

public class StringDemo {
    public static void main(String[] args) {
        String s1=new String("a");
        String s2="123";
        char[] a={};
        String s3=new String(a);
        byte[] b={};
        String s4=new String(b);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
