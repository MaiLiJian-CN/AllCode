package com.yichen.serializable;

import java.io.*;

public class ObjectOutputStreamDemo2 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream oos=new ObjectInputStream(new FileInputStream("file-io-app\\src\\object.txt"));
        Student sd= (Student) oos.readObject();
        System.out.println(sd);
    }
}
