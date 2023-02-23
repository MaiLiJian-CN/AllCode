package com.yichen.inetAddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) throws Exception{
        //获取本机地址对象
        InetAddress ip1=InetAddress.getLocalHost();
        System.out.println(ip1);
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        System.out.println("==================================");

        //获取域名Ip对象
        InetAddress ip2=InetAddress.getByName("www.baidu.com");
        System.out.println(ip2);
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        System.out.println("==================================");

        //获取公网IP对象
        InetAddress ip3=InetAddress.getByName("183.232.231.172");
        System.out.println(ip3.getHostAddress());
        System.out.println(ip3.getHostName());

        //测试是否可以1秒内ping通。
        System.out.println(ip3.isReachable(1000));
    }
}
