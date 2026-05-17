package taskThree.Demo1;

public class Test {
    public static void main(String[] args){
        //创建三个对象，并调用register方法
        Student s=new Student("张三",19);
        Teacher t=new Teacher("李四",40);
        Administrator a=new Administrator("王五",35);
        register(s); //调用学生类的show方法
        System.out.println("-------");
        register(t); //调用老师类的show方法
        System.out.println("-------");
        register(a); //调用管理员类的show方法
    }
    //为了使方法既可接收学生，又能接收老师和管理员，
    //只能将参数写成这三个类型的父类
    public static void register(Person p){
        p.show();
    }
}
