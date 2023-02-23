package 排列计数;

public class Main {
    public static void main(String[] args) {
        int rs=1;
        for (int i = 1; i <= 10; i++) {
            rs*=i;
        }
        System.out.println(rs);
    }
}
