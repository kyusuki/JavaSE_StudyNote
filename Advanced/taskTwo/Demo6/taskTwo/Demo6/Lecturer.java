package taskTwo.Demo6;

public class Lecturer extends Teacher{
    public Lecturer(){}
    public Lecturer(String id,String name){
        super(id,name);
    }    
    public void lec(){
        System.out.println("讲课");
    }
    public void print(){
        System.out.println(getId()+" "+getName());
    }
}
