package com.yichen.transer;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        try (
                InputStream is=new FileInputStream("file-io-app\\src\\Reader.txt");
                Reader rd=new InputStreamReader(is);
                BufferedReader brd=new BufferedReader(rd);

                OutputStream os=new FileOutputStream("file-io-app\\src\\Reader2.txt");
                Writer osw=new OutputStreamWriter(os);
                BufferedWriter bsw=new BufferedWriter(osw);
                ){
                    char[] bytes=new char[1024];
                    int len;
                    while ((len=brd.read(bytes))!=-1){
                        bsw.write(bytes,0,len);
                    }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
