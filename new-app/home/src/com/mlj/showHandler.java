package com.mlj;

public class showHandler {
    public static void main(String[] args) {
        useshowHandlerImpl(new showHandlerImpl() {
            @Override
            public void show() {
                System.out.println("做作业");
            }
        });
        useshowHandlerImpl(()-> System.out.println("自己做作业"));
    }

    public static void useshowHandlerImpl(showHandlerImpl showHandler){
        showHandler.show();
    }
}

interface showHandlerImpl{
    void show();
}