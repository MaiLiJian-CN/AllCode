package com.yichen.charset;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class OutStreamDemo {
    public static void main(String[] args) throws Exception{
        //创建输出字节管道流与文件接通
        OutputStream os=new FileOutputStream("file-io-app\\src\\out.txt",true);
        //写数据
        //os.write(int a);写一个字节
        os.write('a');
        os.write(65);
//        os.write('麦');
//        os.flush();
        //os.write(byte[] bytes);写一个字节数组
        byte[] b1={'b',66,'c',67};
        os.write(b1);
        os.write("\r\n".getBytes());//换行
        byte[] b2="我叫麦立健".getBytes();
        os.write(b2);
        os.write("\r\n".getBytes());//换行
//        System.out.println(Arrays.toString(b2));
//        System.out.println(new String(b2));

        os.close();
    }
}
