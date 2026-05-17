package CarRental;
import java.util.List;
import java.util.Arrays;
public class Car {
    private String carId; //车辆ID
    private String carModel; //车型
    private double dailyPrice; //日租金
    private String status="待租凭"; //车辆状态
    private double mileage=0; //里程数
    public Car(){}
    public Car(String carId,String carModel,double dailyPrice,String status,double mileage){
        this.carId=carId;
        this.carModel=carModel;
        this.dailyPrice=dailyPrice;
        this.status=status;
        this.mileage=mileage;
    }
    public String getCarId(){
        return carId;
    }
    public void setCarId(String carId){
        this.carId=carId;
    }
    public String getCarModel(){
        return carModel;
    }
    public void setCarModel(String carModel){
        this.carModel=carModel;
    }
    public double getDailyPrice(){
        return dailyPrice;
    }
    public void setDailyPrice(double dailyPrice){
        if(dailyPrice>=0){
            this.dailyPrice=dailyPrice;
        }
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newstatus){
        List<String> allows=Arrays.asList("待租凭","租凭中","维修中");
        if(allows.contains(newstatus)){
            this.status=newstatus;
        }
        else{
            System.out.println("状态更新失败");
        }
    }
    public double getMileage(){
        return mileage;
    }
    public void setMileage(double mileage){
        if(mileage>=0){
            this.mileage=mileage;
        }
    }
}
