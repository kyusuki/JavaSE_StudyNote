package Test9;

import java.util.Comparator;
import java.util.TreeMap;

public class test9 {
    public static void main(String[] args){
        Student s1=new Student("zhangsan",23);
        Student s2=new Student("lisi",20);
        Student s3=new Student("wangwu",25);
        TreeMap<Student,String> tm=new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1,Student o2){
                int result=o1.getAge()-o2.getAge();
                if(result<0){
                    return -1;
                }
                if(result==0){
                    int result1=o1.getName().compareTo(o2.getName());
                    if(result1<0){
                        return -1;
                    }
                    if(result1==0){
                        return 0;
                    }
                }
                return 1;
            }
        });
        tm.put(s1,"北京");
        tm.put(s2,"上海");
        tm.put(s3,"深圳");
        System.out.println(tm);
    }
}
