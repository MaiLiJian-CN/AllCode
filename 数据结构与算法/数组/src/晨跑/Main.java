package 晨跑;

public class Main {
    public static void main(String[] args) {
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int now=6;
        int rs=0;
        for (int i = 0; i < 12; i++) {
            for (int j = 1; j <= days[i]; j++) {
                if (now==6||now==7||j==1||j==11||j==21|j==31){
                    rs++;
                    if (now==7){
                        now=0;
                    }
                }
                now++;
            }
        }
        System.out.println(rs);
    }
}
