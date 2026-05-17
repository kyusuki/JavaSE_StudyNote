package taskFive.Demo6;

public class bkCoach extends Bk{
    public bkCoach(){}
    public bkCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void Basketball(){
        System.out.println(getName()+" "+getAge()+" 教打篮球");
    }
}
