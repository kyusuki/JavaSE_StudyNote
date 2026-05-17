package PetFosterCare;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dog extends Pet{
    private String breed;
    private boolean needWalk=false; //默认不需散步
    public Dog(){}
    public Dog(String petId,String nickname,int age,double weight,String ownerContact,String fosterStatus,String breed,boolean needWalk){
        super(petId,nickname,age,weight,ownerContact,fosterStatus);
        this.breed=breed;
        this.needWalk=needWalk;
    }
    public String getBreed(){
        return breed;
    }
    public void setBreed(String breed){
        this.breed=breed;
    }
    public boolean getNeedWalk(){
        return needWalk;
    }
    public void setNeedWalk(boolean needWalk){
        this.needWalk=needWalk;
    }
    //重写基础费用
    @Override
    public double calculateFosterFee(int days){
        double addFee=0.0,fee=0.0;
        if(needWalk){
            addFee=50.0;
        }
        fee=(getWeight()*30.0+addFee)*days;
        BigDecimal result=new BigDecimal(fee);
        result=result.setScale(2,RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
