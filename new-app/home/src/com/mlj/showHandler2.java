package com.mlj;

public class showHandler2 {

    public static void main(String[] args) {
        useshowHandler2(new showHandlerImpl2() {
            @Override
            public void show(String msg) {
                System.out.println(msg);
            }
        });
        useshowHandler2(System.out::println);
    }
    public static void useshowHandler2(showHandlerImpl2 showHandler){
        showHandler.show("写作业");
    }
}

interface showHandlerImpl2{
    void show(String msg);
}