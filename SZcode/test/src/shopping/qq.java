public class qq{
 public static void main(String[] args){
  java.util.Scanner sc=new java.util.Scanner(System.in);
  
  lo:while(true){
   System.out.print("��: ");
   int week = sc.nextInt();
   switch(week){
    case 0:
        System.out.println("�˳�");
     break lo;
    case 1:
        System.out.println("�ܲ�");
     break;
    case 2:
     System.out.println("��Ӿ");
     break;
    case 3:
     System.out.println("����");
     break;
    case 4:
     System.out.println("���е���");
     break;
    case 5:
     System.out.println("ȭ��");
     break;
    case 6:
     System.out.println("��ɽ");
     break;
    case 7:
     System.out.println("�úó�һ��");
     break;
   }
  }
 }
}