package taskSix.Demo1;

public class Dog implements Behave{
    public Dog(){
        System.out.println("大狗叫");
    }
    @Override
    public void woof(){
        System.out.println("喜欢大狗大狗叫叫叫");
    }
    @Override
    public void play(){
        System.out.println("喜欢做核酸");
    }
}
