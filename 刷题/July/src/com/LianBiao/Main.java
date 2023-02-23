package com.LianBiao;

public class Main {
    public static Node head=new Node();
    public static void main(String[] args) {
        lianBiao(3);//4个节点
        /*
        * 1、若链表节点数为 2n，请反转 n+1 ~ 2n 的部分（n 为正整数）；
        * 2、若链表节点数为 2n+1，请反转 n+1 ~ 2n+1 的部分（n 为正整数）。
        */
        reNode();
        Node temp=head;
        while (temp.nextNode!=null){
            System.out.println(temp.value);
            temp=temp.nextNode;
        }
    }
    public static void reNode(){
        int len=0;
        Node temp=head;
        //获取节点长度
        while (temp!=null){
            len++;
            temp=temp.nextNode;
        }
        if (len%2==0){
//            若链表节点数为 2n，请反转 n+1 ~ 2n 的部分
            int num=len-(len/2+1);
            //从n+1开始反转，我只需要找到n
            int n=len/2;
            temp=head;
            //找到链表头
            for (int i = 0; i < n-1; i++) {
                temp=temp.nextNode;
            }
            Node node1=temp.nextNode;
            if (node1.nextNode==null) return;
            for (int i = 0; i < num; i++) {
                Node node2=node1.nextNode;
                while (node2.nextNode!=null){
                    node2=node2.nextNode;
                }
                temp.nextNode=node2;
                node1=node1.nextNode;
                temp=temp.nextNode;
            }
            temp.nextNode=node1;
            node1.nextNode=null;

        }else {
//            若链表节点数为 2n+1，请反转 n+1 ~ 2n+1 的部分
        }
    }

    public static void lianBiao(int num){
        Node temp=head;
        int i=0;
        head.value=i;
        while (true){
            Node node = new Node();
            node.value=++i;
            while (temp.nextNode!=null){
                temp=temp.nextNode;
            }
            temp.nextNode=node;
            if (temp.nextNode.value==num) return ;
        }
    }
}
class Node{
    public int value;
    public Node nextNode;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", nextNode=" + nextNode +
                '}';
    }
}
