package com.yichen.charset;

import java.io.*;

public class Demo3 {
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream("file-io-app\\src\\test.txt");
        /**


        byte[] bytes=new byte[3];
        int len=is.read(bytes);
        System.out.println("读取了多少字节："+len);
        String rs=new String(bytes);
        System.out.println(rs);

        int len2= is.read(bytes);
        System.out.println("读取了多少个字节："+len2);
        String rs2=new String(bytes);
        System.out.println(rs2);

        int len3=is.read(bytes);
        System.out.println("读取了多少个字节:"+len3);
        String rs3=new String(bytes,0,len3);
        System.out.println(rs3);
 */
        byte[] bytes=new byte[3];
        int len;
        while ((len=is.read(bytes))>0){
            //System.out.println("读取了："+len);
            System.out.print(new String(bytes,0,len));
        }
        is.close();
    }
}
