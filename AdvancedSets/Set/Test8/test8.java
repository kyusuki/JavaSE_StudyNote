package Test8;

import java.util.TreeSet;

public class test8 {
    public static void main(String[] args){
        TreeSet<Student> ts=new TreeSet<>();
        ts.add(new Student("zhangsan",23,90,99,50));
        ts.add(new Student("lisi",24,90,98,50));
        ts.add(new Student("wangwu",25,95,100,30));
        ts.add(new Student("zhaoliu",26,60,99,70));
        ts.add(new Student("qianqi",26,70,80,70));
        for(Student s:ts){
            System.out.println(s);
        }
    }        
}
