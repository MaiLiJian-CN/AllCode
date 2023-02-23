package shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemDemo {
    static Scanner sc=new Scanner(System.in);
    static String shopName;
    static Double ShopMoney;
    static int sum;
    static ArrayList<Shoplist> shopList=new ArrayList<>();
    public static void main(String[] args) {
        /**
         * 接收商品
         */

        while (true) {
            System.out.println("扫描商品输入1，结账输入-1");
            String check=sc.next();
            switch (check){
                case "1":
                    Shoplist sp = shopCount();
                    shopList.add(sp);
                    break;
                case "-1":
                    if (shopList.size()==0){
                        System.out.println("当前未扫描到商品");
                        break;
                    }
                    ShopSum(shopList);
                    return;
                default:
                    System.out.println("重新输入");
                    break;
            }
        }
    }

    private static void ShopSum(ArrayList<Shoplist> shopList) {
        Double moneyAll = 0.0;
        for (Shoplist shoplist : shopList) {
            System.out.println("商品名字："+shoplist.getName()+"价格："+shoplist.getMoney()+"数量："+shoplist.getCount());
            moneyAll+=shoplist.getMoney()*shoplist.getCount();
        }
        System.out.println("总付："+moneyAll);
        System.out.println("欢迎下次");
        return;
    }

    private static Shoplist shopCount() {
        while (true) {
            System.out.println("请输入商品名称：");
            shopName = sc.next();
            System.out.println("请输入商品价钱:");
            ShopMoney = sc.nextDouble();
            System.out.println("请输入商品数量:");
            int sum= sc.nextInt();
            if (shopName!=null && ShopMoney>0.0 && sum>0){
                Shoplist sp=new Shoplist(shopName,ShopMoney,sum);
                return sp;
            }else {
                System.out.println("商品信息有误，重新输入");
            }
        }

//        System.out.println(sp);

    }


}
