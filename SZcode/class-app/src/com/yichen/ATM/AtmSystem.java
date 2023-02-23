package com.yichen.ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AtmSystem {
    static ArrayList<Account> accounts=new ArrayList<>();
    static {
        //存放测试数据
        Account accTest1=new Account("01234567","麦立健","123",0,1000);
        Account accTest2=new Account("12345678","抑晨","123",0,2000);
        accounts.add(accTest1);
        accounts.add(accTest2);
    }
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("====================欢迎进入ATM系统======================");
        while (true) {
            System.out.println("请选择你的操作：1，注册。2，登录");
            String command = sc.next();
            switch (command){
                case "1":
                    register(); //注册
                    break;
                case "2":
                    //登录
                    login();
                    break;
                default:
                    System.out.println("无此操作选择");
            }
        }
    }

    private static void login() {
        if (accounts.size()==0) return;
        while (true) {
            System.out.println("===========欢迎进入登录界面===============");
            System.out.println("请输入卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId);
            if (acc!=null){
                System.out.println("============登录成功==============");
                System.out.println("===========欢迎你,"+acc.getUserName()+"=============");
                showUserCommand(acc);
                return;
            }else {
                System.out.println("卡号有误");
                break;
            }
        }
    }

    private static void showUserCommand(Account acc) {
        while (true) {
            System.out.println("请选择你的操作:1.查询 2.存款 3.取款 4.转账 5.修改 6.退出 7.注销");
            String command=sc.next();
            switch (command){
                case "1":
                    showUser(acc);
                    break;
                case "2":
                    depositMoney(acc);
                    break;
                case "3":
                    drawMoney(acc);
                    break;
                case "4":
                    transferMoney(acc);
                    break;
                case "5":
                    revisePassoword(acc);
                    break;
                case "6":
                    System.out.println("欢迎下次再来");
                    return;
                case "7":
                    deleteUser(acc);
                    return;
                default:
                    System.out.println("无此操作，重新开始");
            }
        }
    }

    private static void deleteUser(Account acc) {
        System.out.println("是否选择注销账户:y/n");
        String chose = sc.next();
        if ("y".equals(chose)) {
            accounts.remove(acc);
            System.out.println("注销成功");
            return;
        }
        System.out.println("已退出,暂不注销");
        System.out.println("-------------------------");

    }

    private static void revisePassoword(Account acc) {
        System.out.println("请输入当前密码：");
        String pw = sc.next();
        if (acc.getPassWord().equals(pw)){
            while (true) {
                String password = checkWord();
                if (password!=null){
                    acc.setPassWord(password);
                    return;
                }else {
                    System.out.println("两次密码不一致，重来！");
                }
            }
        }else {
            System.out.println("当前密码错误");
        }
    }

    private static void transferMoney(Account acc) {
        if (accounts.size()>=2){
            while (true) {
                System.out.println("=========欢迎进入转账界面==========");
                System.out.println("请输入转账卡号：");
                String cardId = sc.next();
                //查询卡号
                Account account = getAccountByCardId(cardId);
                if (account!=null){
                    //用户验证
                    String accountName ="*"+account.getUserName().substring(1);
                    System.out.println(accountName);
                    System.out.println("用户验证，输入用户姓氏:");
                    String checkName = sc.next();
                    if (account.getUserName().startsWith(checkName)){
                        //转账逻辑
                        System.out.println("请输入转账金额:");
                        double money = sc.nextDouble();
                        if (acc.getMoney()>money && acc.getQuoteMoney()>money){
                            //可以转账
                            acc.setMoney(acc.getMoney()-money);
                            account.setMoney(account.getMoney()+money);
                            System.out.println("-----------转账成功---------");
                            showUser(acc);
                            return;
                        }else {
                            System.out.println("余额不足或者超出当日限额");
                            showUser(acc);
                        }
                    }else {
                        System.out.println("签名不对");
                    }
                }else {
                    System.out.println("无此用户");
                }
            }
        }else {
            System.out.println("当前系统账户不足，无法转账");
        }
    }

    private static void drawMoney(Account acc) {
        if (acc.getMoney()!=0){
            while (true) {
                System.out.println("-------------------------------------");
                System.out.println("请输入取款金额：");
                double money = sc.nextDouble();
                if (acc.getQuoteMoney()>=money){
                    //在限额内
                    if (acc.getMoney()>money){
                        //有足够的金额
                        acc.setMoney(acc.getMoney()-money);
                        showUser(acc);
                        return;
                    }else {
                        System.out.println("余额不足");
                    }
                }else {
                    System.out.println("取款金额大于限额");
                }
            }
        }
        System.out.println("当前无金额");

    }

    private static void depositMoney(Account acc) {
        System.out.println("请选择你的存款金额：");
        double money = sc.nextDouble();
        acc.setMoney(money);
        System.out.println("-----------------------------");
        showUser(acc);
    }

    private static void showUser(Account acc) {
        System.out.println("卡号："+acc.getCardId());
        System.out.println("户主："+acc.getUserName());
        System.out.println("限额："+acc.getQuoteMoney());
        System.out.println("存款："+acc.getMoney());
    }

    private static void register() {
        System.out.println("====================欢迎进入注册系统======================");
        while (true) {
            Account acc=new Account();
            System.out.println("请输入用户名:");
            String userName = sc.next();
            acc.setUserName(userName);
           //密码逻辑
            while (true) {
                String passWord = checkWord();
                if (passWord==null){
                    System.out.println("密码不一致。请重新开始");
                }else {
                    acc.setPassWord(passWord);
                    break;
                }
            }
            //额度设置
            System.out.println("请输入当日最大限额：");
            double quoteMoney = sc.nextDouble();
            acc.setQuoteMoney(quoteMoney);
//            System.out.println("===限额成功==");
            //给予卡号
            String cardId = getRandomCardId();
            acc.setCardId(cardId);
            accounts.add(acc);
            return;
        }
    }

    private static String getRandomCardId() {
//        System.out.printf("111");
        Random random=new Random();
        String cardId="";
        while (true) {
            for (int i = 0; i < 8; i++) {
                int id = random.nextInt(10);
                cardId+=id;
            }
            Account acc = getAccountByCardId(cardId);
            if (acc==null){
                System.out.println("当前卡号："+cardId);
                return cardId;
            }
        }
    }

    /**
     * 账户查询
     * @param cardId
     */
    private static Account getAccountByCardId(String cardId) {
        for (Account account : accounts) {
            if(account.getCardId().equals(cardId)){
                return account;
            }
        }
        return null;
    }

    /**
     * 判断密码是否一致
     * @param
     */
    private static String checkWord() {
        System.out.println("请输入密码：");
        String passWord = sc.next();
        System.out.println("请再次输入密码：");
        String okPassword = sc.next();
        if (passWord.equals(okPassword)){
            return passWord;
        }
        return null;
    }
}
