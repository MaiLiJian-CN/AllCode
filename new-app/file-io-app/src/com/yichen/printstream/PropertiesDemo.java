package com.yichen.printstream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Properties;

/**
 * Map体系下的键值对API，用来保存键值对配置
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception{
        Properties ppt=new Properties();
        ppt.setProperty("admin","123456");
        ppt.setProperty("麦立健","123");
        System.out.println(ppt);

        /**
         * 参数一 字符输出管道
         * 参数二 注释
         */
        ppt.store(new FileWriter("file-io-app\\src\\PptDemo.properties"),"测试Properties接口");
    }
}
