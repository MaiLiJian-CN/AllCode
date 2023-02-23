package com.yichen.transer;

import java.io.*;

public class InputStreamDemo {
    public static void main(String[] args) {
        try (InputStream is=new FileInputStream("file-io-app\\src\\Reader.txt");
             Reader rd=new InputStreamReader(is,"GBK");

             BufferedReader brd=new BufferedReader(rd);
             )
        {
            String line;
            while ((line=brd.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
