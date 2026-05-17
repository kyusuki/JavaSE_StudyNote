package taskTwo.Demo5;

public class Test {
    public static void main(String[] args){
        Manage m=new Manage("114514","张三",12345,3456);
        m.work();
        m.eat();
        m.printM();
        System.out.println("-------");
        Chef c=new Chef("514114","李四",7890);
        c.work();
        c.eat();
        c.printC();
    }
}
