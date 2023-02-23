package com.yichen.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    public static void main(String[] args) {
        try {
            System.out.println("==========服务端=======");
            //注册端口
            ServerSocket serverSocket=new ServerSocket(1111);

            //调用accept方法，等待socket连接请求，建立通信管道
            Socket socket=serverSocket.accept();

            //从通信管道中获得字节输入流
            InputStream is=socket.getInputStream();

            //包装缓冲流
            BufferedReader bf=new BufferedReader(new InputStreamReader(is));
            String mg;
            while ((mg=bf.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"发送了:"+mg);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
