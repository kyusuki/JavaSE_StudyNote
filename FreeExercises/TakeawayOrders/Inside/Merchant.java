package Inside;
import java.util.ArrayList;
public class Merchant {
    private String merchantId; //商家ID
    private String shopName; //店铺名
    private String category; //主营品类
    private ArrayList<Food> foodList=new ArrayList<>(); //食物列表
    private ArrayList<Order> orderList=new ArrayList<>(); //订单列表
    private double minOrderPrice; //起送价
    private double deliveryFee; //配送费
    public Merchant(){}
    public Merchant(String merchantId,String shopName,String category,ArrayList<Food> foodList,ArrayList<Order> orderList,double minOrderPrice,double deliveryFee){
        this.merchantId=merchantId;
        this.shopName=shopName;
        this.category=category;
        this.foodList=foodList;
        this.orderList=orderList;
        this.minOrderPrice=minOrderPrice;
        this.deliveryFee=deliveryFee;
    }
    public void setMerchantId(String merchantId){
        this.merchantId=merchantId;
    }
    public String getMerchantId(){
        return merchantId;
    }
    public void setShopName(String shopName){
        this.shopName=shopName;
    }
    public String getShopName(){
        return shopName;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public String getCategory(){
        return category;
    }
    public void setFoodList(ArrayList<Food> foodList){
        this.foodList=foodList;
    }
    public ArrayList<Food> getFoodList(){
        return foodList;
    }
    public void setOrderList(ArrayList<Order> orderList){
        this.orderList=orderList;
    }
    public ArrayList<Order> getOrderList(){
        return orderList;
    }
    public void setMinOrderPrice(double minOrderPrice){
        this.minOrderPrice=minOrderPrice;
    }
    public double getMinOrderPrice(){
        return minOrderPrice;
    }
    public void setDeliveryFee(double deliveryFee){
        this.deliveryFee=deliveryFee;
    }
    public double getDeliveryFee(){
        return deliveryFee;
    }
}
