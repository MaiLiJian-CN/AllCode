package com.FiveOne;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            String num = Integer.toBinaryString(i);
            if (num.length()==1){
               num= "0000"+num;
            }else if (num.length()==2){
                num= "000"+num;
            }else if (num.length()==3){
                num= "00"+num;
            }else if (num.length()==4){
                num= "0"+num;
            }
            System.out.println(num);
        }
    }
}
