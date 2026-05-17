package Test4;

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
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        Student other=(Student)obj;
        return age==other.age && Objects.equals(name,other.name);
    }
    public String toString(){
        return "Student[name="+name+",age="+age+"]";
    }
}
