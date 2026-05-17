package Inside;

public class VIPMember extends Member{
    private double discount; //会员折扣
    public VIPMember(){}
    public VIPMember(String memberId,String name,double balance){
        super(memberId,name,balance,"正常");
    }
    public void setDiscount(double discount){
        if(discount>=0.5&&discount<=1.0){
            this.discount=discount;
            System.out.println("VIP折扣设置为："+(int)(discount*100)+"%");
        }
        else{
            System.out.println("折扣范围必须在0.5-1.0之间");
        }
    }
    public double getDiscount(){
        return discount;
    }
    //重写VIP报名课程
    @Override
    public boolean enrollCourse(Course course,Gym gym){
        double vipPrice=course.calculateVIPPrice(this.discount);
        if(gym.enrollCourse(this, course)){
            setBalance(getBalance()-vipPrice);
            System.out.println("报名成功，已扣减"+vipPrice+"元");
            return true;
        }
        else{
            System.out.println("报名失败，余额不足");
            return false;
        }
    }
    @Override
    public String toString(){
        return "VIP会员ID："+getMemberId()+" 姓名："+getName()+" 余额："+getBalance()+" 状态："+getStatus()+" 折扣："+(int)(discount*100)+"%";
    }
}
