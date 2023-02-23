
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请输入成绩：");
            int score= sc.nextInt();
            if (score>=0&&score<=100){
                if (score>=95){
                    System.out.println("自行车一辆");
                }else if (score>=90){
                    System.out.println("游乐场一次");
                }else if (score>=80){
                    System.out.println("变形金刚一个");
                }else {
                    System.out.println("挨揍");
                }
            }else {
                System.out.println("输入有误");
            }
        }
    }
}
