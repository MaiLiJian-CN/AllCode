package 队列;

import java.util.Scanner;

/**
 * 做出一个环形队列
 * 区别CircleArrayQueueDemo
 * read取值不预留一个位置
 */
public class MyCircleArrQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入最大数");
        MyCircleArrQueue queue =new MyCircleArrQueue(scanner.nextInt());
        while (true){
            System.out.println("请选择操作");
            System.out.println("1:addQueue");
            System.out.println("2:getQueue");
            System.out.println("3:showQueue");
            System.out.println("4:headQueue");
            switch (scanner.nextInt()){
                case 1:
                    queue.addQueue(scanner.nextInt());
                    continue;
                case 2:
                    queue.getQueue();
                    continue;
                case 3:
                    queue.showQueue();
                    continue;
                case 4:
                    queue.headQueue();
                    continue;
                default:
                    return;
            }
        }
    }
}
class  MyCircleArrQueue{
    private int[] arr;//模拟队列的数组
    private int front;//队列头部
    private int read;//队列尾巴
    private int maxSize;//队列最大数

    /**
     * 构造函数
     * @param max:队列长度
     */
    public MyCircleArrQueue(int max){
        maxSize=max;
        arr=new int[maxSize];
        front=0;
        read=-1;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        if (read==-1) return false;
        return (read+1)%maxSize==front;
    }

    /**
     *判断队列是否空
     */
    public boolean isEmpty(){
        return read==-1;
    }

    /**
     * 添加数据
     */
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列满了");
        }else {
            if (read==-1){
                arr[++read]=data;
            }else {
                read=(read+1)%maxSize;
                arr[read]=data;
            }
            System.out.println("OK!!!");
        }
    }

    /**
     *取出数据
     */
    public void getQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            System.out.println(arr[front]);
            front=(front+1)%maxSize;
        }
    }

    /**
     *展示队列数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i = front; i <=front+size(); i++) {
                System.out.printf("arr[%d]=%d\n",(i%maxSize),arr[i%maxSize]);
            }
        }
    }
    private int size() {
        return (read-front+maxSize)%maxSize;
    }

    /**
     * 获取头部数据
     */
    public void headQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            System.out.println(arr[front]);
        }
    }
}
