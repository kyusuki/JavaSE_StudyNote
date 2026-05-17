package taskTwo.Demo6;

public class Tutor extends Teacher{
    public Tutor(){}
    public Tutor(String id,String name){
        super(id,name);
    }
    public void tut(){
        System.out.println("辅导");
    }
    public void print(){
        System.out.println(getId()+" "+getName());
    }
}
