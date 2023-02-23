package PresonSample;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sample {


    public static void main(String[] args) {
        //测试数据
        Person p = new Person();
        p.setName("张三");
        p.setCard("450234200007123456");
        p.setTelephone("13677234785");

        Scanner sc = new Scanner(System.in);
        /**
         * 变量定义
         */
        String specimenNo;
        String person=p.getName();
        String sampleValue;
        String result;
        /**
        //测试对象
        System.out.println("核酸检测者姓名:");
        person = sc.next();
        p.setName(person);
        System.out.println("核酸检测者电话:");
        p.setTelephone(sc.next());
        System.out.println("核酸检测者身份证号码:");
        p.setCard(sc.next());
         */
        System.out.println("=====================");
        collect(p);
        System.out.println("=====================");
        test(p);


    }

    private static void  test(Person person) {
        System.out.println(person.getName()+"正在核酸检测");
        System.out.println("结果为阴性");
        System.out.println("信息如下");
        System.out.println("===============================");
        System.out.println(person.getName()+"的信息为：“"+person.getName()+",电话:\n"
                +person.getTelephone()+",身份证号：\n"+person.getCard()+"”");
    }

    private static void collect(Person person) {
        System.out.println("核酸采集姓名:"+person.getName());
        System.out.println("信息如下");
        person.PrintlnFo();
    }

}
class Person {
    private String name;
    private String telephone;
    private String card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }






    public void PrintlnFo(){
        System.out.println("姓名:"+this.name+" 电话号码:"+this.telephone+" 身份证:"+this.card);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
