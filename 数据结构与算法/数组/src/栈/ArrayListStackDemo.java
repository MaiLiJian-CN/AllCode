package 栈;

public class ArrayListStackDemo {
    public static void main(String[] args) {
        StackList list = new StackList();
        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.addData(4);
        list.addData(5);
        list.addData(6);
        list.show();
        System.out.println("================");
        list.pop();
        list.pop();
        list.pop();
        System.out.println("================");
        list.show();
    }
}
class StackList{
   private StackData top=new StackData(-1);
   public void addData(int data){
       StackData stack = new StackData(data);
       StackData temp=top;
       while (temp.getPre()!=null){
           temp=temp.getPre();
       }
       temp.setPre(stack);
   }
   public void show(){
       StackData temp=top.getPre();
       int length=0;
       while (temp!=null){
           length++;
           temp=temp.getPre();
       }
       for (int i = length-1; i >= 0; i--) {
           StackData data=top;
           for (int j = 0; j <= i; j++) {
               data=data.getPre();
           }
           System.out.println(data.getData());

       }
   }
   public int pop(){
       StackData temp=top.getPre();
       while (temp.getPre().getPre()!=null){
           temp=(temp.getPre());
       }
       int data=temp.getPre().getData();
       temp.setPre(null);
       return data;
   }
}

class StackData {
    private StackData pre;
    private int data;

    public StackData(int data) {
        this.data = data;
    }

    public StackData getPre() {
        return pre;
    }

    public void setPre(StackData pre) {
        this.pre = pre;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ArrayListStack{" +
                "data=" + data +
                '}';
    }
}