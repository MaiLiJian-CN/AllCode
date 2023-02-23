package com.yichen.charset;

import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo2 {
    public static void main(String[] args) throws Exception{
        Reader r=new FileReader("file-io-app\\src\\Reader.txt");
        char[] ch=new char[1024]; //1k字符
        int len;
        while ((len=r.read(ch))>0){
            String sr=new String(ch,0,len);
            System.out.println(sr);
        }
    }
}
