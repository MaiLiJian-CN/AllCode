package com.yichen.charset;

import java.io.*;

public class BufferReadDemo {
    public static void main(String[] args) {
        try (Reader rd=new FileReader("file-io-app\\src\\writer.txt");)//经典代码
        {
            //字符缓冲流
            BufferedReader brd=new BufferedReader(rd);
            String line;
            while ((line=brd.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
