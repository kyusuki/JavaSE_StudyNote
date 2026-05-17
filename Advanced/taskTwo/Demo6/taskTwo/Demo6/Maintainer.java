package taskTwo.Demo6;

public class Maintainer extends AdminStaff{
    public Maintainer(){}
    public Maintainer(String id,String name){
        super(id,name);
    }
    public void mai(){
        System.out.println("维护");
    }
    public void print(){
        System.out.println(getId()+" "+getName());
    }
}
