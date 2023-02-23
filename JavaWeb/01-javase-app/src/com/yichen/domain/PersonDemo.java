package com.yichen.domain;

public class PersonDemo {
    private String name;
    private int age;
    public String test;
    public String string;

    public PersonDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonDemo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PersonDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", test='" + test + '\'' +
                '}';
    }
//    public void eat(String food){
//        System.out.println("eat......"+food);
//    }

    public static void eat(){
        System.out.println("eat......");
    }
}
