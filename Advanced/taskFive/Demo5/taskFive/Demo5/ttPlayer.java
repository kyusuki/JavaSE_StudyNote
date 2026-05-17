package taskFive.Demo5;

public class ttPlayer extends tt{
    public ttPlayer(){}
    public ttPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void play(String subject){
        System.out.println(getName()+" "+getAge()+" 打"+subject);
    }
}
