package com.yichen.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerDemo3Thread extends Thread{
    private Socket socket;
    public ServerDemo3Thread(Socket sockets){
        this.socket=sockets;
    }

    @Override
    public void run() {
        //从通信管道中获得字节输入流
        try {
            InputStream is = socket.getInputStream();
            //包装缓冲流
            BufferedReader bf=new BufferedReader(new InputStreamReader(is));
            String mg;
            while ((mg=bf.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"发送了:"+mg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
