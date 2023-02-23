package com.yichen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.Future;

/**
 * 发送端 一发一收
 */
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String  message="exit";
        /**
        Runnable r1=new Ser();
        Thread t1=new Thread(r1);
        t1.start();
         */
        System.out.println("==========客户端===========");
        //创建发送端对象，发送端自带默认的端口号
        DatagramSocket socket=new DatagramSocket(6666);

        //创建一个数据包对象封装数据
//        byte[] bytes=new byte[1024*64];


        /**
         * public DatagramPacket(byte buf[], int length,
         *                           InetAddress address, int port)
         * 封装的数据 发送数据的大小 服务端的IP地址 服务端的端口
         */
        while (true){
            System.out.println("请说：");
            String input=sc.nextLine();
            if (input.equals(message)){
                System.out.println("退出成功");
                socket.close();
            }
            byte[] bytes=input.getBytes();
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8888);
            socket.send(packet);
        }


    }
}

/**
class Ser implements Runnable{

    @Override
    public void run() {
        System.out.println("===========服务端=============");
        //创建接收端，注册端口
        DatagramSocket socket= null;
        try {
            socket = new DatagramSocket(8888);


        //创建数据包，接收对象
        byte[] bytes=new byte[1024*64];
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);

        //接收数据
        socket.receive(packet);
        System.out.println(new String(bytes,0, packet.getLength()));
        socket.close();
        System.out.println("已接收");
        }catch (Exception e) {
            e.printStackTrace();
        }
   }
}
 */