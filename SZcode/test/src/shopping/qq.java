public class qq{
 public static void main(String[] args){
  java.util.Scanner sc=new java.util.Scanner(System.in);
  
  lo:while(true){
   System.out.print("数: ");
   int week = sc.nextInt();
   switch(week){
    case 0:
        System.out.println("退出");
     break lo;
    case 1:
        System.out.println("跑步");
     break;
    case 2:
     System.out.println("游泳");
     break;
    case 3:
     System.out.println("慢跑");
     break;
    case 4:
     System.out.println("动感单车");
     break;
    case 5:
     System.out.println("拳击");
     break;
    case 6:
     System.out.println("爬山");
     break;
    case 7:
     System.out.println("好好吃一顿");
     break;
   }
  }
 }
}