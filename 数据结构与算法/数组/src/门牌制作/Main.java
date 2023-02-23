package 门牌制作;

public class Main {
    public static void main(String[] args) {
        int num=0;
        for (int i = 1; i <= 2020; i++) {
            String value = String.valueOf(i);
            for (int j = 0; j < value.length(); j++) {
                if (value.charAt(j)=='2'){
                 num++;
                }
            }
        }
        System.out.println(num);
    }
}
