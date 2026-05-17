package Inside;

public class VIPUser extends User{
    private double discount=0.9; //初始默认为9折
    public VIPUser(){}
    public VIPUser(String userId,String userName,String address,String phone,double balance,double discount){
        super(userId,userName,address,phone,balance);
        this.discount=discount;
    }
    public void setDiscount(double discount){
        if(discount>=0.1&&discount<=1){
            this.discount=discount;
        }
        else{
            System.out.println("折扣必须在0.1到1之间");
        }
    }
    public double getDiscount(){
        return discount;
    }
}
