package taskTwo.Demo6;

public class AdminStaff extends Employee{
    public AdminStaff(){
        System.out.println("行政部");
    }
    public AdminStaff(String id,String name){
        super(id,name);
    }
    public void as(){
        System.out.println("行政工作");
    }
}
