package com.yichen.charset;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) {
        try {
            //创建了一个字节输入管道流
            InputStream is=new FileInputStream("D:\\BaiduNetdiskDownload\\牧马人 (1982).mp4");
            //创建了一个字节输出管道流
            OutputStream os=new FileOutputStream("D:\\Download\\牧马人(1982).mp4");
            //创建字节数组接收数据
            byte[] bytes=new byte[1024];
            int len;
            while ((len= is.read(bytes))>0){
                os.write(bytes,0,len);
            }
            os.close();
            is.close();
            System.out.println("复制完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
