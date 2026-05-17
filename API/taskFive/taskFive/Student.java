package taskFive;
import java.util.Objects;
public class Student {
    private String name;
    private int age;
    public Student(){}
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public String toString(){
        return name+" "+age;
    }
    //重写之后的equals方法比较的就是对象的属性
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        Student student=(Student)obj;
        return age==student.age&&Objects.equals(name,student.name);
    }
}
