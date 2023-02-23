package com.yichen.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多发多收
 */
public class ServerDemo3 {
    public static void main(String[] args) {
        try {
            System.out.println("==========服务端=======");
            //注册端口
            ServerSocket serverSocket=new ServerSocket(9999);

            //调用accept方法，等待socket连接请求，建立通信管道
            while (true){
                Socket socket=serverSocket.accept();
                new ServerDemo3Thread(socket).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
