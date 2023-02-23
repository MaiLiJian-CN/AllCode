package com.yichen.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        Student s1=new Student("麦立健","mailijian","mlj");
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("file-io-app\\src\\object.txt"));
        oos.writeObject(s1);
        oos.close();
    }
}
