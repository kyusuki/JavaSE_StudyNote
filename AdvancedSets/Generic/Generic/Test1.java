package Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args){
        //没有泛型时，可以存储任意类型对象，但是会导致类型转换异常
        /*
         * ArrayList list1=new ArrayList<>();
         * list1.add(111);
         * list1.add("aaa");
         * list1.add(new Student("张三",20));
         * Iterator it=list1.iterator();
         * while(it.hasNext()){
         *     Object obj=it.next();
         *     System.out.println(obj); //111 aaa 姓名：张三，年龄：20
         * } 
         */
        ArrayList<Student> list2=new ArrayList<>();
        list2.add(new Student("张三",20));
        list2.add(new Student("李四",21));
        list2.add(new Student("王五",22));
        Iterator<Student> it=list2.iterator();
        while(it.hasNext()){
            Student stu=it.next();
            System.out.println(stu);
        }
    }
}

class Student{
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
}