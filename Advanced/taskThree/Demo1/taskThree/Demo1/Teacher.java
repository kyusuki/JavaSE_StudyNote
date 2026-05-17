package taskThree.Demo1;

public class Teacher extends Person{
    public Teacher(){}
    public Teacher(String name,int age){
        super(name,age);
    }    
    @Override
    public void show(){
        System.out.println("老师的信息为："+getName()+" "+getAge());
    }
}
