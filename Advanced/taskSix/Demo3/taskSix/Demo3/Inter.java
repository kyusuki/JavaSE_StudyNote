package taskSix.Demo3;

public interface Inter {
    public default void show1(){
        System.out.println("show1");
    }
    public default void show2(){
        System.out.println("show2");
    }
    private void show3(){
        System.out.println("叮咚鸡");
    }
    public static void show4(){
        System.out.println("show4");
    }
    public static void show5(){
        System.out.println("show5");
    }
    private static void show6(){
        System.out.println("大狗叫");
    }
}
