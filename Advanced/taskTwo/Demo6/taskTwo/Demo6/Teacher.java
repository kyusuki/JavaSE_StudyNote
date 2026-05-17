package taskTwo.Demo6;

public class Teacher extends Employee{
    public Teacher(){
        System.out.println("教研部");
    }
    public Teacher(String id,String name){
        super(id,name);
    }
    public void tr(){
        System.out.println("教研工作");
    }
}
