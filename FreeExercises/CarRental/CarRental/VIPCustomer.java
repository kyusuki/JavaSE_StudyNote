package CarRental;

public class VIPCustomer extends Customer {
    private double discount=0.9; //折扣，默认0.9
    public VIPCustomer(){}
    public VIPCustomer(String custId,String custName,double deposit,String status,double discount){
        super(custId,custName,deposit,status);
        this.discount=discount;
    }
    public double getDiscount(){
        return discount;
    }
    public void setDiscount(double discount){
        if(discount>=0.5&&discount<=1){
            this.discount=discount;
        }
    }
}
