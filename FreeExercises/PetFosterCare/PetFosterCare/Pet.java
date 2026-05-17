package PetFosterCare;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
public class Pet {
    private String petId;
    private String nickname;
    private int age;
    private double weight;
    private String ownerContact;
    private String fosterStatus="待寄养"; //默认初始为待寄养
    public Pet(){}
    public Pet(String petId,String nickname,int age,double weight,String ownerContact,String fosterStatus){
        this.petId=petId;
        this.nickname=nickname;
        this.age=age;
        this.weight=weight;
        this.ownerContact=ownerContact;
        this.fosterStatus=fosterStatus;
    }
    public String getPetId(){
        return petId;
    }
    public void setPetId(String petId){
        this.petId=petId;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        if(weight>0){
            this.weight=weight;
        }
        else{
            System.out.println("体重不能小于等于0");
        }
    }
    public String getOwnerContact(){
        return ownerContact;
    }
    public void setOwnerContact(String ownerContact){
        this.ownerContact=ownerContact;
    }
    public String getFosterStatus(){
        return fosterStatus;
    }
    public void setFosterStatus(String newFosterStatus){
        List<String> allowStatus=Arrays.asList("待寄养","寄养中","已接走");
        if(allowStatus.contains(newFosterStatus)){
            this.fosterStatus=newFosterStatus;
            System.out.println("寄养状态更新成功");
        }
        else{
            System.out.println("寄养状态更新失败");
        }
    }
    //基础费用
    public double calculateFosterFee(int days){
        double fee=0.0;
        fee=getWeight()*30.0*days;
        BigDecimal result=new BigDecimal(fee);
        result=result.setScale(2,RoundingMode.HALF_UP);
        return result.doubleValue();
    }
}
