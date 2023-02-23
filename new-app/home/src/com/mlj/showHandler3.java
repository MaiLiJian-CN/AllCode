package com.mlj;

import java.util.Random;

public class showHandler3 {
    public static void main(String[] args) {
        useshowHandler3Impl(new showHandler3Impl() {
            @Override
            public Integer show() {
                return new Random().nextInt(10)+1;
            }
        });
        useshowHandler3Impl(()->new Random().nextInt(10)+1);
    }

    public static void useshowHandler3Impl(showHandler3Impl showHandler3){
        System.out.println(showHandler3.show());
    }
}

interface showHandler3Impl {
    Integer show();
}