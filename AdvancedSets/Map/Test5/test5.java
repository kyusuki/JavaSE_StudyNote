package Test5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class test5 {
    public static void main(String[] args){
        Student s1=new Student("张三",23);
        Student s2=new Student("李四",24);
        Student s3=new Student("王五",25);
        Student s4=new Student("李四",24);
        HashMap<Student,String> map=new HashMap<>();
        map.put(s1,"北京");
        map.put(s2,"上海");
        map.put(s3,"深圳");
        map.put(s4,"重庆");
        Set<Student> keys=map.keySet();
        //增强for遍历
        for(Student key:keys){
            String value=map.get(key);
            System.out.println(key+" "+value);
        }
        System.out.println(map.put(s4,"西安")); //重庆

        System.out.println("----------------");

        //迭代器遍历
        Iterator<Student> it=keys.iterator();
        while(it.hasNext()){
            Student key=it.next();
            String value=map.get(key);
            System.out.println(key+" "+value);
        }
        System.out.println(map.put(s4,"成都")); //西安

        System.out.println("----------------");

        //Lambda表达式遍历
        keys.forEach((key)->{
            String value=map.get(key);
            System.out.println(key+" "+value);
        });
    }
}
