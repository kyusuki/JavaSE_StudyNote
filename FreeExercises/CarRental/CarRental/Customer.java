package CarRental;
import java.util.List;
import java.util.Arrays;
public class Customer {
    private String custId; //客户ID
    private String custName; //姓名
    private double deposit; //押金
    private String status="正常"; //状态，初始为正常
    public Customer(){}
    public Customer(String custId,String custName,double deposit,String status){
        this.custId=custId;
        this.custName=custName;
        this.deposit=deposit;
        this.status=status;
    }
    public String getCustId(){
        return custId;
    }
    public void setCustId(String custId){
        this.custId=custId;
    }
    public String getCustName(){
        return custName;
    }
    public void setCustName(String custName){
        this.custName=custName;
    }
    public double getDeposit(){
        return deposit;
    }
    public void setDeposit(double deposit){
        if(deposit>=0){
            this.deposit=deposit;
        }
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newstatus){
        List<String> allows=Arrays.asList("正常","冻结");
        if(allows.contains(newstatus)){
            this.status=newstatus;
        }
        else{
            System.out.println("状态更新失败");
        }
    }
}
