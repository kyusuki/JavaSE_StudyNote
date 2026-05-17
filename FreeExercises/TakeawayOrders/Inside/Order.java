package Inside;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Order {
    private String orderId; //订单ID
    private User user; //下单用户
    private ArrayList<OrderItem> orderItems=new ArrayList<>(); //订单项列表
    private String status="未支付"; //订单状态
    private double totalPrice; //总金额
    public Order(){}
    public Order(String orderId,User user,ArrayList<OrderItem> orderItems,double totalPrice){
        this.orderId=orderId;
        this.user=user;
        this.orderItems=orderItems;
        this.totalPrice=totalPrice;
    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    public String getOrderId(){
        return orderId;
    }
    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }
    public void setOrderItems(ArrayList<OrderItem> orderItems){
        this.orderItems=orderItems;
    }
    public ArrayList<OrderItem> getOrderItems(){
        return orderItems;
    }
    public void setTotalPrice(double totalPrice){
        if(totalPrice>=0){
            this.totalPrice=totalPrice;
        }
        else{
            System.out.println("订单总金额不能为负值");
        }
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void setStatus(String newStatus){
        List<String> allowedList=Arrays.asList("待支付","已支付","已完成","已取消");
        if(allowedList.contains(newStatus)){
            this.status=newStatus;
            System.out.println("订单状态更新为："+newStatus);
        }
        else{
            System.out.println("无效的订单状态："+newStatus+"，请选择待支付，已支付，已完成，已取消");
        }
    }
    public String getStatus(){
        return status;
    }
    class OrderItem{
        private Food food;
        private int buyNum; //购买数量
        public OrderItem(){}
        public OrderItem(Food food,int buyNum){
            this.food=food;
            this.buyNum=buyNum;
        }
        public void setFood(Food food){
            this.food=food;
        }
        public Food getFood(){
            return food;
        }
        public void setBuyNum(int buyNum){
            if(buyNum>=1){
                this.buyNum=buyNum;
            }
            else{
                System.out.println("购买数量不能小于1");
            }
        }
        public int getBuyNum(){
            return buyNum;
        }
    }
}
