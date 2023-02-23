package com.yichen.printstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws Exception {
        Properties ppt=new Properties();
        ppt.load(new FileReader("file-io-app\\src\\PptDemo.properties"));
        System.out.println(ppt);
        System.out.println(ppt.get("admin"));
        System.out.println(ppt.get("麦立健"));
    }
}
