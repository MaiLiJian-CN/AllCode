package 跑步锻炼;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] days={31,29,31,30,31,30,31,31,30};
        int now=6;
        int rs=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j <=days[i]; j++) {
                if (now==8){
                    now=1;
                }
                if (j==1||now==1){
                    rs+=2;
                }else {
                    rs+=1;
                }
                now++;
            }
        }
        System.out.println(rs+2);
    }
}
