package shopping;

import java.io.PrintStream;

public class Shoplist {
    private String name;
    private Double money;
    private int count;

    public Shoplist(String name, Double money, int count) {
        this.name = name;
        this.money = money;
        this.count = count;
    }

    public Shoplist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Shoplist{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", count=" + count +
                '}';
    }
}
