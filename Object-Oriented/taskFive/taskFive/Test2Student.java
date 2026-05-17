package taskFive;

public class Test2Student {
    public static void main(String[] args){
        Student2 stu1=new Student2();
        System.out.println(stu1);
        stu1.name="小明";
        stu1.age=18;
        stu1.sex="男";
        System.out.println(stu1.name+" "+stu1.age+" "+stu1.sex);
        stu1.study();
        Student2 stu2=new Student2();
        System.out.println(stu2);
        stu2.name="小红";
        stu2.age=19;
        stu2.sex="女";
        System.out.println(stu2.name+" "+stu2.age+" "+stu2.sex);
        stu2.study();
    }
}
