package com.yichen.charset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream("LogBack-app\\Filetest.txt");
        int b1=is.read();
        System.out.println((char) b1);
        int b2= is.read();
        System.out.println((char) b2);
        int b3= is.read();
        System.out.println((char) b3);
        is.close();
    }
}
