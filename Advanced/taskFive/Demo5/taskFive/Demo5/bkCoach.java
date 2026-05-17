package taskFive.Demo5;

public class bkCoach extends bk{
    public bkCoach(){}
    public bkCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void teach(String subject){
        System.out.println(getName()+" "+getAge()+" 教打"+subject);
    }
}
