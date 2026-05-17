package Lambda;

public class Test2 {
    public static void main(String[] args){
        method(
            ()->{
                System.out.println("正在游泳🏊‍");
            }
        );
    }
    public static void method(Swim swim){
        swim.swim();
    }
}
interface Swim{
    public abstract void swim();
}
