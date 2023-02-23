package com.yichen.file;

public class JuiceDemo {
    /**
     * 啤酒问题
     * 2yuan一瓶酒，四盖换一瓶，2空换一瓶
     */
    public static int total;
    public static int totalCover;//盖子
    public static int totalBottle;//空瓶

    public static void main(String[] args) {
        buy(10);
        System.out.println(total);
        System.out.println(totalCover);
        System.out.println(totalBottle);
    }

    private static void buy(int money) {
        int butNum=money/2;//一次性买
        total+=butNum;
        int cover=totalCover+butNum;
        int bottle=totalBottle+butNum;

        //换算
        int allMoney=0;
        if (cover>=4){
            allMoney+=(cover/4)*2;
        }
        totalCover=cover%4;
        if (bottle>=2){
            allMoney+=(bottle/2)*2;
        }
        totalBottle=bottle%2;

        if (allMoney>=2){
            buy(allMoney);
        }
    }
}
