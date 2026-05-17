package 综合案例2;

public class Goods {
    private String id;
    private String name;
    private double price;
    private int num;
    public Goods(){}
    public Goods(String id,String name,double price,int num){
        this.id=id;
        this.name=name;
        this.price=price;
        this.num=num;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public void setNum(int num){
        this.num=num;
    }
    public int getNum(){
        return num;
    }
}
