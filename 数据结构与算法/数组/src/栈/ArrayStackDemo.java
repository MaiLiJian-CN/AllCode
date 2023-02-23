package 栈;


public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        System.out.println("=======================");
        stack.push(1);
        stack.push(12);
        stack.push(124);
        stack.push(1245);
        stack.push(5);
        stack.showStack();
        System.out.println("=======================");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("=======================");
        stack.showStack();
    }
}

class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组，模拟栈
    private int top=-1;//表示栈顶，初始值为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }
    //判断栈满
    public boolean isFull(){
        return this.top==this.maxSize-1;
    }
    //判断栈空
    public boolean isEmpty(){
        return this.top==-1;
    }
    //入栈
    public void push(int data){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        this.stack[++top]=data;
    }
    //出栈
    public int pop(){
        if (isEmpty()) return -1;
        /*int data=stack[top];
        top-=1;
        return data;*/
         return stack[top--];
    }

    public void showStack(){
        if (isEmpty()) return;
        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}