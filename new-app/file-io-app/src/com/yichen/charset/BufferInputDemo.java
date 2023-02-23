package com.yichen.charset;

import java.io.*;

public class BufferInputDemo {
    public static void main(String[] args) {
        try (InputStream is=new FileInputStream("D:\\DreamW\\1.gif");
             BufferedInputStream bi=new BufferedInputStream(is);
             OutputStream os=new FileOutputStream("D:\\DreamW\\2.gif");
             BufferedOutputStream bo=new BufferedOutputStream(os))
        {
            byte[] bytes=new byte[1024];
            int len;
            while ((len= bi.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
            System.out.println("ok");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
