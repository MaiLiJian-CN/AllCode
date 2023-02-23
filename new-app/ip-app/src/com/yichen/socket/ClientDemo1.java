package com.yichen.socket;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建socket通信管道请求
 */
public class ClientDemo1 {

    public static void main(String[] args) throws Exception{
        /**
         * 创建Socket通信管道请求有服务器连接
        Socket(String host,int port)
         服务器IP地址 服务器端口
         */
        Socket socket=new Socket("127.0.0.1",7777);

        //从socket通信管道获得一个字节输出流，负责发数据
        OutputStream osp=socket.getOutputStream();

        //低级字节流包装成打印流
        PrintStream ps=new PrintStream(osp);

        //发送消息

        ps.println("我是TCP的客户端，请求对接");
        ps.flush();

        //关闭资源
//        socket.close();

    }
}
