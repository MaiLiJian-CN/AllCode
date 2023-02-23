package 卡片;

public class Main {
    public static void main(String[] args) {
        int rs=0;
        for (int i = 1; ; i++) {
            for (int j = i; j !=0 ; j/=10) {
                if (j%10==1) rs++;
                if (rs>=2021) {
                    System.out.println(i);
                    return;
                };
            }
        }
    }
}
