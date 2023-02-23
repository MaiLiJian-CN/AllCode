package 队列;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入最大数");
        ArrayQueue queue =new ArrayQueue(scanner.nextInt());
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
                    System.out.println(queue.getQueue());
                    continue;
                case 3:
                    queue.showQueue();
                    continue;
                case 4:
                    System.out.println(queue.headQueue());
                    continue;
                default:
                    return;
            }
        }
    }
}

/*使用数组模拟队列*/
class ArrayQueue{
    private int[] arr;//模拟队列
    private final int maxSize;//表示数组最大容量
    private int front;//队列头
    private int rear;//队列尾

    /*创建队列构造器*/
    public ArrayQueue(int arrMaxSize){
        this.maxSize=arrMaxSize;
        arr=new int[this.maxSize];
        this.front=-1;//指向队列头
        this.rear=-1;//指向队列尾
    }
    //判断队列是否满
    public boolean isFull(){
        return this.rear==this.maxSize-1;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return this.rear==this.front;
    }
    //添加数据到队列
    public void addQueue(int data){
        if (!isFull()){
            this.rear++;
            this.arr[this.rear]=data;
        }else {
            System.out.println("满");
        }
    }
    //获取数据，出队列
    public int getQueue(){
        //判断队列是否空
        if (!isEmpty()){
            this.front++;//front后移
            return this.arr[this.front];
        }else {
            System.out.println("队列空");
            return -1;
        }
    }
    //显示队列所有数据
    public void showQueue(){
        if (!isEmpty()){
            for (int i = 0; i < this.arr.length; i++) {
                System.out.printf("arr[%d]=%d\n",i,this.arr[i]);
            }
        }else {
            System.out.println("队列空");;
        }
    }
    //显示头数据
    public int headQueue(){
        if (!isEmpty()){
            return this.arr[++this.front];
        }else {
            System.out.println("空队列");
            return -1;
        }
    }
}