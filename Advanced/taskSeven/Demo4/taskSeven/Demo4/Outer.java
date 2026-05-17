package taskSeven.Demo4;

public class Outer {
    static int b=10;
    public void show(){
        int a=20;
        class Inner{
            public void method1(){
                System.out.println(a);
                System.out.println("局部内部类非静态方法");
            }
            public static void method2(){
                System.out.println(b);
                System.out.println("局部内部类静态方法");
            }
        }
        Inner inner=new Inner();
        inner.method1();
        Inner.method2();
    }
}
