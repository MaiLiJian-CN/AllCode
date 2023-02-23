package com.yichen.printstream;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 打印流
 */
public class PrintDemo1 {
    public static void main(String[] args) throws Exception{
        PrintStream ps=new PrintStream("file-io-app\\src\\print.txt");
        ps.println(97);
        ps.println('a');
        ps.println("我是字节输出打印流");
        ps.close();

        PrintWriter ps1= new PrintWriter("file-io-app\\src\\print1.txt");
        ps1.write(97);
        ps1.write("\n");
        ps1.write('a');
        ps1.write("我是字符输出打印流");
        ps1.close();
    }
}
