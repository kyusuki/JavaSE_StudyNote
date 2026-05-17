package Test3;

import java.util.HashSet;

public class test3 {
    public static void main(String[] args){
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",25);
        Student s4=new Student("张三",23);
        HashSet<Student> set=new HashSet<>();
        System.out.println(set.add(s1)); //true
        System.out.println(set.add(s2)); //true
        System.out.println(set.add(s3)); //true
        System.out.println(set.add(s4)); //false，重写后的结果
        System.out.println(set); //[Student[name=张三,age=23], Student[name=李四,age=24], Student[name=王五,age=25]]
    }
}
