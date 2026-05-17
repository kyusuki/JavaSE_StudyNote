package taskSeven.Demo3;

public class Outer {
    static class Inner{
        public void show1(){
            System.out.println("非静态方法已调用");
        }
        public static void show2(){
            System.out.println("静态方法已调用");
        }
    }
}
