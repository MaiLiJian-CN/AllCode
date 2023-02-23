package com.yichen.charset;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) throws Exception {
        Writer wr=new FileWriter("file-io-app\\src\\writer.txt",true);
        wr.write(65);
        wr.write("abc");
        wr.write('麦');
        wr.write("\r\n");

        wr.write("我是麦立健");
        wr.write("\r\n");

        char[] ch="深圳职业技术学院".toCharArray();
        wr.write(ch);
        wr.write("\r\n");

        wr.write("123456",0,3);
        wr.write("\r\n");

        wr.write(ch,0, ch.length);
        wr.close();
    }
}
