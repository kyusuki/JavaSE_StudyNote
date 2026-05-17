package taskFive.Demo5;

public class tt extends People implements Speak{
    public tt(){}
    public tt(String name,int age){
        super(name,age);
    }
    @Override
    public void speak(){
        System.out.println("说英语");
    }
    public void play(String subject){
        System.out.println(getName()+" "+getAge()+" 打"+subject);
    }
    public void teach(String subject){
        System.out.println(getName()+" "+getAge()+" 教"+subject);
    }
}
