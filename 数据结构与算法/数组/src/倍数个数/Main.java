package 倍数个数;

public class Main {
    public static void main(String[] args) {
        int num=0;
        for (int i = 10000; i <=90000 ; i++) {
            if (i%128==0){
                num++;
            }
        }
        System.out.println(num);
    }
}
