package Inside;
import java.util.List;
import java.util.Arrays;
public class Member {
    private String memberId; //会员ID
    private String name; //会员真实姓名
    private double balance=0; //账户余额,默认初始为0
    private String status="正常"; //会员状态
    public Member(){}
    public Member(String memberId,String name,double balance,String status){
        this.memberId=memberId;
        this.name=name;
        this.balance=balance;
        this.status=status;
    }
    public void setMemberId(String memberId){
        this.memberId=memberId;
    }
    public String getMemberId(){
        return memberId;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    public void setStatus(String newStatus){
        List<String> allowedList=Arrays.asList("正常","冻结");
        if(allowedList.contains(newStatus)){
            this.status=newStatus;
            System.out.println("状态更新成功");
        }
        else{
            System.out.println("状态更新失败");
        }
    }
    public String getStatus(){
        return status;
    }
    //返回当前余额
    public double checkBalance(){
        System.out.println("会员"+getName()+"当前余额："+getBalance()+"元");
        return balance;
    }
    //充值
    public void recharge(double amount){
        if(amount<0){
            System.out.println("充值金额不能为负");
            return;
        }
        else{
            setBalance(getBalance()+amount);
            System.out.println("充值成功，当前余额："+getBalance()+"元");
        }
    }
    //报名课程
    public boolean enrollCourse(Course course,Gym gym){
        if(gym.enrollCourse(this, course)){
            setBalance(getBalance()-course.getPrice());
            System.out.println("报名成功，已扣减"+course.getPrice()+"元");
            return true;
        }
        else{
            System.out.println("报名失败，余额不足");
            return false;
        }
    }
    @Override
    public String toString(){
        return "会员ID："+getMemberId()+" 姓名："+getName()+" 余额："+getBalance()+" 状态："+getStatus();
    }
}
