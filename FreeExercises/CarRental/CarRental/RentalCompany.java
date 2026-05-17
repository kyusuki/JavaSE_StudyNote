package CarRental;
import java.util.ArrayList;
public class RentalCompany {
    private String companyName; //公司名称
    private ArrayList<Car> carList=new ArrayList<>(); //车辆列表
    private ArrayList<Customer> customerList=new ArrayList<>(); //客户列表
    private ArrayList<RentalOrder> orderList=new ArrayList<>(); //订单列表
    public RentalCompany(){}
    public RentalCompany(String companyName,ArrayList<Car> carList,ArrayList<Customer> customerList,ArrayList<RentalOrder> orderList){
        this.companyName=companyName;
        this.carList=carList;
        this.customerList=customerList;
        this.orderList=orderList;
    }
    public String getCompanyName(){
        return companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }
    public ArrayList<Car> getCarList(){
        return carList;
    }
    public void setCarList(ArrayList<Car> carList){
        this.carList=carList;
    }
    public ArrayList<Customer> getCustomerList(){
        return customerList;
    }
    public void setCustomerList(ArrayList<Customer> customerList){
        this.customerList=customerList;
    }
    public ArrayList<RentalOrder> getOrderList(){
        return orderList;
    }
    public void setOrderList(ArrayList<RentalOrder> orderList){
        this.orderList=orderList;
    }
}
