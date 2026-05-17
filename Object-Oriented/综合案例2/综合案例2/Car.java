package 综合案例2;

public class Car {
    private String brand;
    private double price;
    private String color;
    public Car(){}
    public Car(String brand,double price,String color){
        this.brand=brand;
        this.price=price;
        this.color=color;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
}
