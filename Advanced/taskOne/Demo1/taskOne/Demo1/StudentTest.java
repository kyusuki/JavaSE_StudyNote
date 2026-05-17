package taskOne.Demo1;

public class StudentTest {
    public static void main(String[] args){
        Student s1=new Student();
        Student.teacherName="王老师";
        s1.setName("张三");
        s1.setAge(21);
        s1.setGender("男");
        s1.study();
        s1.showInfo();
        Student s2=new Student();
        s2.setName("远坂凛");
        s2.setAge(19);
        s2.setGender("女");
        s2.study();
        s2.showInfo();
    }
}
