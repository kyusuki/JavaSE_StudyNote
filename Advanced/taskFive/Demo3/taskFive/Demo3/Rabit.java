package taskFive.Demo3;

public class Rabit extends Animal{
    public Rabit(){}
    public Rabit(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(getName()+"吃胡萝卜");
    }
}
