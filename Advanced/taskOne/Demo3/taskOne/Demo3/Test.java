package taskOne.Demo3;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        ArrayList<Student> list=new ArrayList<>();
        Student s1=new Student("王俊凯",21,"男");
        Student s2=new Student("易烊千玺",19,"男");
        Student s3=new Student("王源",20,"女");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Student maxA=StudentUtil.getMaxAge(list);
        System.out.println("年龄最大的学生是"+maxA.getName()+" "+maxA.getAge()+" "+maxA.getGender());
    }
}
