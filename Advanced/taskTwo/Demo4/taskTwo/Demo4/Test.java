package taskTwo.Demo4;

public class Test {
    public static void main(String[] args){
        //Student s1=new Student();
        Student s2=new Student("张三",20);
        System.out.println(s2.name+" "+s2.age);
    }
}
class Person{
    String name;
    int age;
    public Person(){
        System.out.println("父类的无参构造");
    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
}
class Student extends Person{
    public Student(){
        //super(); //调用父类的无参构造
        System.out.println("子类的无参构造");
    }
    public Student(String name,int age){
        super(name,age);
    }
}