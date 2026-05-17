package taskThree;

public class Student {
    private String name;
    private int age;
    //空参构造 (如果没有写构造方法，虚拟机会默认给你一个空参构造)
    public Student(){
        System.out.println("空参构造");
    }
    //有参构造
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
