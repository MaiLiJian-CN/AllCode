package com.yichen.transer;

import java.io.*;

/**
 * 不同编码的情况
 * 字符输入转换流
 */
public class CharSetDemo {
    public static void main(String[] args) {
        try (Reader rd=new FileReader("file-io-app\\src\\Reader.txt");
             BufferedReader brd=new BufferedReader(rd);)
        {
            String line;
            while ((line=brd.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
