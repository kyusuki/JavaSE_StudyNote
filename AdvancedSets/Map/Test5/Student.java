package Test5;

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
    public String toString(){
        return "姓名："+name+"，年龄："+age;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }
    @Override
    public boolean equals(Object ob){
        if(this==ob){
            return true;
        }
        if(ob instanceof Student){
            Student s=(Student)ob;
            if(this.name.equals(s.name)&&this.age==s.age){
                return true;
            }
        }
        return false;
    }
}
