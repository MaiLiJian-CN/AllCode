
import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.print("������������ڼ���");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        switch (num){
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
            default:
                System.out.println("�����������");
        }
    }
}
