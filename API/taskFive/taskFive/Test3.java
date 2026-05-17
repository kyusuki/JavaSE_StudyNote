package taskFive;

import java.util.Objects;

public class Test3 {
    public static void main(String[] args){
        Student s1=null;
        Student s2=new Student("zhangsan",20);
        boolean result1=Objects.equals(s1, s2);
        System.out.println(result1); //false
        boolean result2=Objects.isNull(s1);
        System.out.println(result2); //true
        boolean result3=Objects.nonNull(s1);
        System.out.println(result3); //false
    }
}
