package com.yichen.file;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\administered\\Desktop\\腾讯云.docx");
        long size = file.length();
        System.out.println(size);
        //File f2=new File("LogBack-app\\Filetest.txt");
        //System.out.println(f2.length());
        System.out.println("========================================================");
        //1.创建对象
        File f3=new File("LogBack-app\\Filetest.txt");
        //2.获取对象绝对路径
        System.out.println(f3.getAbsolutePath());
        //3.获取对象创建路径
        System.out.println(f3.getPath());
        //4.获取对象大小
        System.out.println(f3.length());
        //5.获取对象最后修改时间
        long time=f3.lastModified();
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time));
        //6.获取对象名称
        System.out.println(f3.getName());
    }
}
