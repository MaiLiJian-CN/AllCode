package 相同字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String next = new Scanner(System.in).next();
        getRepeatStr(next);
    }
    public static void getRepeatStr(String str){
        //处理为空情况
        if(str==null || str.length()<1){
            return ;
        }
        int maxi=0,maxlen=0,len=0;
        for(int i=1;i<str.length();i++){
            for(int j=0;j<str.length()-i;j++){
                if(str.charAt(j)==str.charAt(i+j)){
                    len++;
                } else {
                    len=0;
                }

                if(len>maxlen){
                    maxlen=len;
                    maxi=j-len;
                }
            }
        }
        if(maxlen>0){
            System.out.println(str.substring(maxi, maxlen));
            System.out.println(maxlen);
        }
    }
}