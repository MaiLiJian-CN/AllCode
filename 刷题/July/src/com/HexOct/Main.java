package com.HexOct;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();

        String[] a= new String[n];

        for(int i=0;i<n;i++){
            a[i]=scanner.next();//接受用户输入
        }

        scanner.close();

        for(int i=0;i<n;i++){
            String strBinary = toBary(a[i]);//先转换为二进制
            int len = strBinary.length();//看转化完的二进制长度
            if(len%3==1) strBinary = "00" + strBinary;//敲黑板。。。注意八进制是三个二进制数一组，所以模三，不是3的整数倍的在前面补零
            if(len%3==2) strBinary = "0" + strBinary;
            String strOctal = toOctal(strBinary);
            System.out.println(strOctal);
        }
    }
    //十六进制转二进制算法
    private static String toBary(String strShi){
        int len_strShi = strShi.length();//长度
        StringBuffer sBuffer = new StringBuffer();
        for(int i=0;i<len_strShi;i++){
            switch (strShi.charAt(i)) {//截取十六进制数的每一个字符，并将其转换为对应二进制数
                case '0':sBuffer.append("0000");break;
                case '1':sBuffer.append("0001");break;
                case '2':sBuffer.append("0010");break;
                case '3':sBuffer.append("0011");break;
                case '4':sBuffer.append("0100");break;
                case '5':sBuffer.append("0101");break;
                case '6':sBuffer.append("0110");break;
                case '7':sBuffer.append("0111");break;
                case '8':sBuffer.append("1000");break;
                case '9':sBuffer.append("1001");break;
                case 'A':sBuffer.append("1010");break;
                case 'B':sBuffer.append("1011");break;
                case 'C':sBuffer.append("1100");break;
                case 'D':sBuffer.append("1101");break;
                case 'E':sBuffer.append("1110");break;
                case 'F':sBuffer.append("1111");break;
                default:
                    break;
            }
        }
        return sBuffer.toString();
    }
    //二进制转换为八进制算法
    private static String toOctal(String strBinary) {
        int len = strBinary.length();
        int k;

        StringBuffer sBuffer = new StringBuffer();
        if (strBinary.substring(0, 3).equals("000")) {//看看前三位是不是0，是零就从第四位开始截取
            k=3;

        } else {
            k=0;
        }

        for(int i=k;i<len-2;i+=3){
            switch (strBinary.substring(i,i+3)){
                case "000":sBuffer.append("0");break;
                case "001":sBuffer.append("1");break;
                case "010":sBuffer.append("2");break;
                case "011":sBuffer.append("3");break;
                case "100":sBuffer.append("4");break;
                case "101":sBuffer.append("5");break;
                case "110":sBuffer.append("6");break;
                case "111":sBuffer.append("7");break;
                default:
                    break;
            }
        }
        return sBuffer.toString();
    }

}