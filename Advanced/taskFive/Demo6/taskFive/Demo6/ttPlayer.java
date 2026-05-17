package taskFive.Demo6;

public class ttPlayer extends Tt{
    public ttPlayer(){}
    public ttPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void TableTennis(){
        System.out.println(getName()+" "+getAge()+" 打乒乓球");
    }
}
