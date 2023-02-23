package com.yichen.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接收端(服务端先启动)
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception{
        System.out.println("===========服务端=============");
        //创建接收端，注册端口
        DatagramSocket socket=new DatagramSocket(8888);

        //创建数据包，接收对象
//        byte[] bytes=new byte[64];


        //接收数据
        while (true) {
            byte[] bytes=new byte[64];

            DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
            socket.receive(packet);
//            System.out.println(new String(bytes,0, packet.getLength()));
            System.out.println("来自"+packet.getAddress()+"端口号："+packet.getPort()+"的消息:"
                    +new String(bytes,0,packet.getLength()));
        }


    }
}
