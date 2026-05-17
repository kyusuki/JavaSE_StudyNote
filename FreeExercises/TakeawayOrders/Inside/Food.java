package Inside;

public class Food {
    private String foodId; //食物ID
    private String foodName; //食物名称
    private double price; //单价
    private int stock; //库存
    private Merchant merchantId; //所属商家ID
    public Food(){}
    public Food(String foodId,String foodName,double price,int stock,Merchant merchantId){
        this.foodId=foodId;
        this.foodName=foodName;
        this.price=price;
        this.stock=stock;
        this.merchantId=merchantId;
    }
    public void setFoodId(String foodId){
        this.foodId=foodId;
    }
    public String getFoodId(){
        return foodId;
    }
    public void setFoodName(String foodName){
        this.foodName=foodName;
    }
    public String getFoodName(){
        return foodName;
    }
    public void setPrice(double price){
        if(price>=0){
            this.price=price;
        }
        else{
            System.out.println("单价不能小于0");
        }
    }
    public double getPrice(){
        return price;
    }
    public void setStock(int stock){
        if(stock>=0){
            this.stock=stock;
        }
        else{
            System.out.println("库存不能为负值");
        }
    }
    public int getStock(){
        return stock;
    }
    public void setMerchantId(Merchant merchantId){
        this.merchantId=merchantId;
    }
    public Merchant getMerchantId(){
        return merchantId;
    }
}
