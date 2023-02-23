package students;

public class Phone {
    private String brand;
    private float price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Phone(String brand, float price) {
        this.brand = brand;
        this.price = price;
    }

    public Phone() {
        System.out.println("无参构造器");
    }
}
