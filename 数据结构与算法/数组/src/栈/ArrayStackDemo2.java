package 栈;


public class ArrayStackDemo2 {
    public static void main(String[] args) {
//        String expression="3+2*6-2";
        String expression="100+100";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';
        String keepNum="";
        while (index<expression.length()){
            ch=expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch)<= operStack.priority(operStack.peak())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                        operStack.push(ch);
                }
            }else {
                keepNum+=ch;
                if (index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }
            }
            index++;
        }
        while (!operStack.isEmpty()){
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(expression+"="+numStack.pop());

    }
}

class ArrayStack2{
    private int maxSize;//栈的大小
    private int[] stack;//数组，模拟栈
    private int top=-1;//表示栈顶，初始值为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }
    public int peak(){
        return stack[top];
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

    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}