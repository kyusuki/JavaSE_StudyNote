package taskTwo.Demo6;

public class Test {
    public static void main(String[] args){
        //Teacher teacher=new Teacher();
        Lecturer l=new Lecturer("001","张三");
        l.lec();
        l.print();
        System.out.println("-------");
        Tutor t=new Tutor("002","李四");
        t.tut();
        t.print();
        System.out.println("-------");
        //AdminStaff adminstaff=new AdminStaff();
        Maintainer m=new Maintainer("003","王五");
        m.mai();
        m.print();
        System.out.println("-------");
        Buyer b=new Buyer("004","赵六");
        b.buy();
        b.print();
        System.out.println("-------");
    }
}
