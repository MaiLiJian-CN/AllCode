package com.yichen.algorithm.test;

import com.yichen.algorithm.sort.Student;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan",18);
        Student s2 = new Student("lisi",17);

        Comparable max = getMax(s1, s2);
        System.out.println(max);
    }
    public static Comparable getMax(Comparable c1,Comparable c2){
        int result=c1.compareTo(c2);
        if (result>=0){
            return c1;
        }else {
            return c2;
        }
    }

}
