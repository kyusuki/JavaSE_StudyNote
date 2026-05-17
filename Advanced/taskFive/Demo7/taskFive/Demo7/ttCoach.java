package taskFive.Demo7;
import taskFive.Demo6.Speak;
public class ttCoach extends Coach implements Speak{
    public ttCoach(){}
    public ttCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void teach(String subject){
        System.out.println(getName()+" is teaching "+subject);
    }
    @Override
    public void speak(){
        System.out.println("speak English");
    }
}
