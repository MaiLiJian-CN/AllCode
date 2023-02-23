package shopping;

import java.util.Scanner;


public class classTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int chose;
        while (true){
            System.out.println("请输入星期几:");
            chose=scanner.nextInt();
            switch (chose){
                case 0:
                    System.out.println("退出");
                    return;
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
                default:
                    System.out.println("别乱来");
            }
        }

    }
}

