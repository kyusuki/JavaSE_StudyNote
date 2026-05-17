package taskFive.Demo7;

public class bkCoach extends Coach{
    public bkCoach(){}
    public bkCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void teach(String subject){
        System.out.println(getName()+" is teaching "+subject);
    }
}
