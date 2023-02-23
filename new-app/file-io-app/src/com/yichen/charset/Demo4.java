package com.yichen.charset;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Demo4 {
    public static void main(String[] args) throws Exception{
        File f=new File("file-io-app\\src\\test.txt");
        InputStream is=new FileInputStream(f);
        byte[] bytes=new byte[(int) f.length()];
        int len=is.read(bytes);
        System.out.println(len);
        System.out.println(f.length());
        System.out.println(new String(bytes));
        is.close();
    }
}
