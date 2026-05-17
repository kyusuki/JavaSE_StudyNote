package taskFive;

public class Test3Student {
    public static void main(String[] args){
        Student3 stu1=new Student3();
        stu1.name="小明";
        Student3 stu2=stu1;
        stu2.name="小红";
        System.out.println(stu1.name+"..."+stu2.name);
        stu1=null;
        //System.out.println(stu1.name); //空指针异常
        System.out.println(stu2.name);
        stu2=null;
        //System.out.println(stu2.name); //空指针异常
    }
}
