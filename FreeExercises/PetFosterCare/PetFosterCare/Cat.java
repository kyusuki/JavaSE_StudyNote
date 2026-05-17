package PetFosterCare;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
public class Cat extends Pet{
    private String hairlength="短毛"; //默认初始为短毛
    private boolean needGroom=false; //默认不需梳毛
    public Cat(){}
    public Cat(String petId,String nickname,int age,double weight,String ownerContact,String fosterStatus,String hairlength,boolean needGroom){
        super(petId,nickname,age,weight,ownerContact,fosterStatus);
        this.hairlength=hairlength;
        this.needGroom=needGroom;
    }
    public String getHairlength(){
        return hairlength;
    }
    public void setHairlength(String newHairlength){
        List<String> allowList=Arrays.asList("短毛","长毛");
        if(allowList.contains(newHairlength)){
            this.hairlength=newHairlength;
            System.out.println("状态更新成功");
        }
        else{
            System.out.println("状态更新失败");
        }
    }
    public boolean getNeedGroom(){
        return needGroom;
    }
    public void setNeedGroom(boolean needGroom){
        this.needGroom=needGroom;
    }
    //重写基础费用
    @Override
    public double calculateFosterFee(int days){
        double addFee=0.0,fee=0.0;
        if(getHairlength().equals("长毛")&&getNeedGroom()==true){
            addFee=30.0;
        }
        fee=(getWeight()*30.0+addFee)*days;
        BigDecimal result=new BigDecimal(fee);
        result=result.setScale(2,RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
