package com.yichen.charset;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String test="abc我爱你中国";
        byte[] d1=test.getBytes();
        System.out.println(Arrays.toString(d1));

        String d2=new String(d1);
        System.out.println(d2);
    }
}
