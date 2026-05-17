package CarRental;

public class RentalOrder {
    private String orderId; //订单ID
    private Customer renter; //客户
    private Car rentedCar; //被租车辆
    private int rentalDays; //租赁天数
    private double totalRent; //总租金
    public RentalOrder(){}
    public RentalOrder(String orderId,Customer renter,Car rentedCar,int rentalDays,double totalRent){
        this.orderId=orderId;
        this.renter=renter;
        this.rentedCar=rentedCar;
        this.rentalDays=rentalDays;
        this.totalRent=totalRent;
    }
    public String getOrderId(){
        return orderId;
    }
    public void setOrderId(String orderId){
        this.orderId=orderId;
    }
    public Customer getRenter(){
        return renter;
    }
    public void setRenter(Customer renter){
        this.renter=renter;
    }
    public Car getRentedCar(){
        return rentedCar;
    }
    public void setRentedCar(Car rentedCar){
        this.rentedCar=rentedCar;
    }
    public int getRentalDays(){
        return rentalDays;
    }
    public void setRentalDays(int rentalDays){
        if(rentalDays>0){
            this.rentalDays=rentalDays;
        }
    }
    public double getTotalRent(){
        return totalRent;
    }
    public void setTotalRent(double totalRent){
        this.totalRent=totalRent;
    }
}
