package taskFive.Demo5;

public class bkPlayer extends bk{
    public bkPlayer(){}
    public bkPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void play(String subject){
        System.out.println(getName()+" "+getAge()+" 打"+subject);
    }
}
