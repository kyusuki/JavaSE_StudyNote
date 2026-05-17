package taskFive.Demo3;

public class Dog extends Animal implements Swim{
    public Dog(){}
    public Dog(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(getName()+"吃骨头");
    }
    @Override
    public void swim(){
        System.out.println("狗刨");
    }
}
