package com.yichen.ATM;

public class Account {
    private String CardId;
    private String userName;
    private String passWord;
    private double money;
    private double quoteMoney;

    public Account() {
    }

    public Account(String cardId, String userName, String passWord, double money, double quoteMoney) {
        CardId = cardId;
        this.userName = userName;
        this.passWord = passWord;
        this.money = money;
        this.quoteMoney = quoteMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getCardId() {
        return CardId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuoteMoney() {
        return quoteMoney;
    }

    public void setQuoteMoney(double quoteMoney) {
        this.quoteMoney = quoteMoney;
    }
}
