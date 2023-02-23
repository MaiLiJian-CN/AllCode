package com.yichen.printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

public class PrintDemo2 {
    public static void main(String[] args) throws Exception {
        /**
         * 打印到文件
         */
        PrintStream ps=new PrintStream("file-io-app\\src\\print2.txt");
        System.setOut(ps);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.parse("2022-02-27 20:40:50"));
    }
}
