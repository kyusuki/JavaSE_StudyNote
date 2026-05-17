package taskFive.Demo7;

public class bkPlayer extends Player{
    public bkPlayer(){}
    public bkPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void play(String subject){
        System.out.println(getName()+" is playing "+subject);
    }
}
