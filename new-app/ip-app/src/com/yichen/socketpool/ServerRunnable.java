package com.yichen.socketpool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnable implements Runnable{
    private Socket socket;
    public ServerRunnable(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try{
            InputStream is=socket.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(is));
            String st;
            while ((st= bf.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"发送了:"+st);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
