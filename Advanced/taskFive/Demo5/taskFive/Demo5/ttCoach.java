package taskFive.Demo5;

public class ttCoach extends tt{
    public ttCoach(){}
    public ttCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void teach(String subject){
        System.out.println(getName()+" "+getAge()+" 教打"+subject);
    }
}
