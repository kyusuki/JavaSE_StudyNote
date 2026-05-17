package taskThree;

public class StudentTest {
    public static void main(String[] args){
    //调用的空参构造方法
    Student s1=new Student();
    s1.setName("王昌龄妈");
    s1.setAge(18);
    System.out.println(s1.getName());
    System.out.println(s1.getAge());


    //调用有参构造方法
    Student s2=new Student("雷霆嘎巴",18);
    System.out.println(s2.getName());
    System.out.println(s2.getAge());
    }
}
