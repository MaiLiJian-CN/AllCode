
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("������ɼ���");
            int score= sc.nextInt();
            if (score>=0&&score<=100){
                if (score>=95){
                    System.out.println("���г�һ��");
                }else if (score>=90){
                    System.out.println("���ֳ�һ��");
                }else if (score>=80){
                    System.out.println("���ν��һ��");
                }else {
                    System.out.println("����");
                }
            }else {
                System.out.println("��������");
            }
        }
    }
}
