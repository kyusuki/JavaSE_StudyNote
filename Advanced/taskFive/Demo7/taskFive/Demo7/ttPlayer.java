package taskFive.Demo7;
import taskFive.Demo6.Speak;
public class ttPlayer extends Player implements Speak{
    public ttPlayer(){}
    public ttPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void play(String subject){
        System.out.println(getName()+" is playing "+subject);
    }
    @Override
    public void speak(){
        System.out.println("speak English");
    }
}
