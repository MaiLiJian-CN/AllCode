package students;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork {
    static ArrayList<Account> accList=new ArrayList<>();
    static {
        Account account=new Account("mlj","123");
        accList.add(account);
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String[] user = sc.nextLine().split(",");
            for (Account account : accList) {
                if (user[0].equals(account.getUserName())){
                    if (user[1].equals(account.getUserPwd())){
                        System.out.println("登录成功");
                        return;
                    }else {
                        System.out.println("密码错误"+"还有:"+(2-i)+"次机会");
                    }
                }else {
                    System.out.println("用户名错误"+(2-i)+"次机会");
                }
            }
        }
    }
}

class Account{
    private String userName;
    private String userPwd;

    public Account(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Account() {
    }
}
