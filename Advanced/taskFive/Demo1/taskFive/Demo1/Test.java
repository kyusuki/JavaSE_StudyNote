package taskFive.Demo1;

public class Test {
    public static void main(String[] args){
        //Person p=new Person(); //抽象类不能实例化
        Student s=new Student("张三",20);
        s.sleep();
        s.work();
        System.out.println(s.getName()+"今年"+s.getAge()+"岁");
    }
}
