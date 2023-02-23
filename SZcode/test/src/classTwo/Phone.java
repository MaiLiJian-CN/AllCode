package classTwo;

public class Phone {
    private String brand;
    private Float price;
    public void call(){
        System.out.println("打电话");
    }
    public void message(){
        System.out.println("发短信");
    }
    public void info(){
        System.out.println(this.brand+","+this.price);
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
class test{
    public static void main(String[] args) {
        Phone ph=new Phone();
        ph.setBrand("三星");
        ph.setPrice(1000.00F);
        ph.info();
    }

}