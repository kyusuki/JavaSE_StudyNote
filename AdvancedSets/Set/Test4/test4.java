package Test4;

import java.util.LinkedHashSet;

public class test4 {
    public static void main(String[] args){
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",25);
        Student s4=new Student("张三",23);
        LinkedHashSet<Student> lhs=new LinkedHashSet<>();
        System.out.println(lhs.add(s1)); //true
        System.out.println(lhs.add(s2)); //true
        System.out.println(lhs.add(s3)); //true
        System.out.println(lhs.add(s4)); //false，重写后的结果
        System.out.println(lhs); //[Student[name=张三,age=23], Student[name=李四,age=24], Student[name=王五,age=25]]
    }
}
