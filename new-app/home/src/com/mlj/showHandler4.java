package com.mlj;

public class showHandler4 {
    public static void main(String[] args) {
        useshowHandler4(new showHandler4Impl() {
            @Override
            public int show(int a, int b) {
                return a+b;
            }
        });
        useshowHandler4(Integer::sum);
    }

    public static void useshowHandler4(showHandler4Impl showHandler4){
        System.out.println(showHandler4.show(2, 3));
    }
}

interface showHandler4Impl{
    int show(int a,int b);
}