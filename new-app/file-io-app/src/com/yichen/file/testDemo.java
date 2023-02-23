package com.yichen.file;

import java.io.File;

public class testDemo {
    public static void main(String[] args) {
        File file=new File("D:\\test\\新建文件夹\\1\\2\\3");
        System.out.println(file.mkdirs());
    }
}
