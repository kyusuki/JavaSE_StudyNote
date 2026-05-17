package taskThree.Demo3;

public class Cat extends Animal{
    public Cat(){}    
    public Cat(int age,String color,String something){
        super(age,color,something);
    }
    @Override
    public void eat(){
        System.out.println("哈吉米喜欢吃"+getSomething());
    }
    public void catchMouse(){
        System.out.println("它的本领是抓老鼠");
    }
}
