package Inside;
import java.util.List;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Course {
    private String courseId; //课程ID
    private String courseName; //课程名称
    private double price; //课程价格
    private int stock=0; //课程库存,默认初始为0
    private String status="待开课"; //课程状态,每次只能存在一个状态
    public Course(){}
    public Course(String courseId,String courseName,double price,int stock,String status){
        this.courseId=courseId;
        this.courseName=courseName;
        this.price=price;
        this.stock=stock;
        this.status=status;
    }
    public void setCourseId(String courseId){
        this.courseId=courseId;
    }
    public String getCourseId(){
        return courseId;
    }
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
    public int getStock(){
        return stock;
    }
    public void setStatus(String newStatus){
        List<String> allowedList=Arrays.asList("待开课","进行中","已结束"); //创建一个课程状态列表，只允许有三个值
        if(allowedList.contains(newStatus)){
            this.status=newStatus; //检验新输入的状态是否在列表中，若在就更新状态
            System.out.println("状态更新成功");
        }
        else{
            System.out.println("状态更新失败");
        }
    }
    public String getStatus(){
        return status;
    }
    //VIP价格
    public double calculateVIPPrice(double discount){
        double result=getPrice()*discount;
        BigDecimal vipPrice=new BigDecimal(result);
        vipPrice=vipPrice.setScale(2,RoundingMode.HALF_UP);
        return vipPrice.doubleValue();
    }
    @Override
    public String toString(){
        return "课程ID："+getCourseId()+" 课程名称："+getCourseName()+" 课程价格："+getPrice()+" 课程库存："+getStock()+" 课程状态："+getStatus();
    }
}
