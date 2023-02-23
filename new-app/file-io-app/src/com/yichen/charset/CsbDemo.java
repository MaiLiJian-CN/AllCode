package com.yichen.charset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class CsbDemo {
    public static void main(String[] args) {
        try (
             BufferedReader brd=new BufferedReader(new FileReader("D:\\java\\code\\new-app\\file-io-app\\src\\csb.txt"));
             BufferedWriter brw=new BufferedWriter(new FileWriter("D:\\java\\code\\new-app\\file-io-app\\src\\new-csb.txt"));
                )
        {
            List<String> list=new ArrayList<>();
            String date;
            while ((date= brd.readLine())!=null){
                list.add(date);
            }
//            System.out.println(list);
            List<String> size=new ArrayList<>();
            Collections.addAll(size,"一","二","三","四","五","六","七","八","九","十","十一");
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return size.indexOf(o1.substring(0,o1.indexOf(".")))-
                            size.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });
            System.out.println(list);
            for (String datum : list) {
                brw.write(datum);
                brw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
