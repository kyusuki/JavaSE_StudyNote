package Inside;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class User {
    private String userId; //用户ID
    private String userName; //姓名
    private String address; //收货地址
    private String phone; //手机号
    private double balance; //余额
    public User(){}
    public User(String userId,String userName,String address,String phone,double balance){
        this.userId=userId;
        this.userName=userName;
        this.address=address;
        this.phone=phone;
        this.balance=balance;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setBalance(double balance){
        if(balance>=0){
            this.balance=balance;
        }
        else{
            System.out.println("余额不能为负值");
        }
    }
    public double getBalance(){
        return balance;
    }
    //余额查询
    public double checkBalance(){
        BigDecimal bd=new BigDecimal(balance);
        bd=bd.setScale(1,RoundingMode.HALF_UP);
        double result=bd.doubleValue();
        System.out.println("用户"+getUserName()+"当前余额："+result+"元");
        return result;
    }
    //余额充值
    public void recharge(double amount){
        if(amount<0){
            System.out.println("充值金额不能为负");
        }
        else{
            setBalance(getBalance()+amount);
            System.out.println("充值成功，当前余额："+getBalance()+"元");
        }
    }
    
}
