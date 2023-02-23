package 队列;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入最大数");
        CircleQueue queue =new CircleQueue(scanner.nextInt()+1);
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
                    try {
                        queue.getQueue();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
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
class CircleQueue{
    private int[] arr;//模拟队列
    private  int maxSize;//表示数组最大容量
    private int front;//队列第一个元素
    private int rear;//队列尾

    public CircleQueue(int max){
        maxSize=max;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列满了");
            return;
        }else {
            arr[rear]=data;
            rear=(rear+1)%maxSize;
            System.out.println("OK");
        }
    }
    public void getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }else {
            System.out.println(arr[front]);
            front=(front+1)%maxSize;
        }
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i = front;i<front+size();i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
        }
    }
    private int size(){
        return (rear-front+maxSize)%maxSize;
    }
    public void headQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            System.out.println(arr[front]);
        }
    }
}
