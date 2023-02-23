package com.yichen.charset;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {
    public static void main(String[] args) throws Exception{
        Reader r= new FileReader("file-io-app\\src\\out.txt");
//        int n=r.read();
//        System.out.println((char) n);
//        int n1=r.read();
//        System.out.println((char) n1);
        int code;
        while ((code=r.read())!=-1){
            System.out.print((char) code);
        }
    }
}
