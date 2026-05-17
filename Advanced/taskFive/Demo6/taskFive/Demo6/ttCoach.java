package taskFive.Demo6;

public class ttCoach extends Tt{
    public ttCoach(){}
    public ttCoach(String name,int age){
        super(name,age);
    }
    @Override
    public void TableTennis(){
        System.out.println(getName()+" "+getAge()+" 教打乒乓球");
    }
}
