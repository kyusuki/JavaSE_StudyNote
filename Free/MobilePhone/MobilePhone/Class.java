package MobilePhone;

public class Class {
    private String brand;
    private String model;
    private double price;
    public Class(){}
    public Class(String brand,String model,double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }
    public void call(String number){
        System.out.println("正在播放电话"+number);
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setModel(String model){
        this.model=model;
    }
    public String getModel(){
        return model;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
}
