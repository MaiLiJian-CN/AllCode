package com.yichen.socketpool;

import com.yichen.socket.ServerDemo3Thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * 多发多收,创建线程池优化
 */
public class ServerDemo {
    //创建静态线程池对象
    private static ExecutorService pool=new ThreadPoolExecutor(2,4,3, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        try {
            System.out.println("==========服务端=======");
            //注册端口
            ServerSocket serverSocket=new ServerSocket(6666);

            //调用accept方法，等待socket连接请求，建立通信管道
            while (true){
                Socket socket=serverSocket.accept();
                Runnable run=new ServerRunnable(socket);
                pool.execute(run);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
