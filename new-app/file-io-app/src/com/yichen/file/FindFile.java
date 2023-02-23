package com.yichen.file;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 递归找文件
 */
public class FindFile {
    public static void main(String[] args) {
        find(new File("D:\\test"),"true.txt");
    }

    private static void find(File dir,String name) {
        if (dir!=null && dir.isDirectory()){
            File[] files=dir.listFiles();
//            System.out.println(Arrays.toString(files));
            if (files!=null && files.length>0){
                for (File getfile : files) {
                    if (getfile.isFile()){
                        if (getfile.getName().contains(name)) {
                            System.out.println(getfile.getAbsolutePath());
                            return;
                        }
                    }else {
                        find(getfile,name);
                    }
                }
            }
        }
    }
}
