package taskTwo.Demo6;

public class Buyer extends AdminStaff{
    public Buyer(){}
    public Buyer(String id,String name){
        super(id,name);
    }
    public void buy(){
        System.out.println("采购");
    }
    public void print(){
        System.out.println(getId()+" "+getName());
    }
}
