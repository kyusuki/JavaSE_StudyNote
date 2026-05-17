package Test13;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class AutomaticRollCall1 {
    public static void main(String[] args){
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("张三",23));
        list.add(new Student("李四",24));
        list.add(new Student("王五",25));
        list.add(new Student("赵六",26));
        list.add(new Student("钱七",27));
        Collections.shuffle(list);
        Random r=new Random();
        int index=r.nextInt(list.size());
        Student stu=list.get(index);
        System.out.println("姓名："+stu.getName()+" 学号："+stu.getId()+" 你被选中了");
    }
}
class Student{
    private String name;
    private int id;
    public Student(){}
    public Student(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
