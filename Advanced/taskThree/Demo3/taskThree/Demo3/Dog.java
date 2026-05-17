package taskThree.Demo3;

public class Dog extends Animal{
    public Dog(){}
    public Dog(int age,String color,String something){
        super(age,color,something);
    }    
    @Override
    public void eat(){
        System.out.println("大狗叫喜欢吃"+getSomething());
    }
    public void lookHome(){
        System.out.println("它的本领是看家");
    }
}
