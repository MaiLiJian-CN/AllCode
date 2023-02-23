package 年份计算;

public class Main {
    public static void main(String[] args) {
        int num=0;
        for (int i =1000; i <=9999 ; i++) {
            String value = String.valueOf(i);
            if (value.charAt(0)==value.charAt(2)){
                if (value.charAt(3)+1==value.charAt(1)){
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
