package com.yichen.charset;

import java.io.*;

public class TotalDemo {
    public static final String Src_file="D:\\BaiduNetdiskDownload\\牧马人 (1982).mp4";
    public static final String Dest_file="D:\\java\\code\\new-app\\test\\";
    public static void main(String[] args) {
        //   copy1();//低级字节流
        copy2();//低级字节流数组
        // copy3();//高级字节流
        copy4();//高级字节流数组
    }

    private static void copy4() {
        System.out.println("开始");
        long start_time=System.currentTimeMillis();
        try (InputStream is=new FileInputStream(Src_file);
             InputStream bis=new  BufferedInputStream(is);
             OutputStream os=new FileOutputStream(Dest_file+"测试4.mp4");
             OutputStream bos=new BufferedOutputStream(os);)
        {
            int a;
            byte[] bytes=new byte[1024];
            while ((a=bis.read(bytes))!=-1){
                bos.write(bytes);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long End_time=System.currentTimeMillis();
        System.out.println("高级字节流数组耗时："+((End_time-start_time)/1000.0)+"s");
        System.out.println("结束");
    }

    private static void copy3() {
        System.out.println("开始");
        long start_time=System.currentTimeMillis();
        try (InputStream is=new FileInputStream(Src_file);
             InputStream bis=new  BufferedInputStream(is);
             OutputStream os=new FileOutputStream(Dest_file+"测试3.mp4");
             OutputStream bos=new BufferedOutputStream(os);)
        {
            int a;
            while ((a=bis.read())!=-1){
                bos.write(a);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long End_time=System.currentTimeMillis();
        System.out.println("高级字节流耗时："+((End_time-start_time)/1000.0)+"s");
        System.out.println("结束");
    }


    private static void copy2() {
        System.out.println("开始");
        long start_time=System.currentTimeMillis();
        try (InputStream is=new FileInputStream(Src_file);

             OutputStream os=new FileOutputStream(Dest_file+"测试2.mp4");)
        {
            byte[] bytes=new byte[1024];
            int a;
            while ((a=is.read(bytes))!=-1){
                os.write(bytes,0,a);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long End_time=System.currentTimeMillis();
        System.out.println("低级字节流数组耗时："+((End_time-start_time)/1000.0)+"s");
        System.out.println("结束");
    }


    private static void copy1() {
        System.out.println("开始");
        long start_time=System.currentTimeMillis();
        try (InputStream is=new FileInputStream(Src_file);

             OutputStream os=new FileOutputStream(Dest_file+"测试1.mp4");)
        {
            int a;
            while ((a=is.read())!=-1){
                os.write(a);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        long End_time=System.currentTimeMillis();
        System.out.println("低级字节流耗时："+((End_time-start_time)/1000.0)+"s");
        System.out.println("结束");
    }
}
