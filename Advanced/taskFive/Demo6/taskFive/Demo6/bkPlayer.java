package taskFive.Demo6;

public class bkPlayer extends Bk{
    public bkPlayer(){}
    public bkPlayer(String name,int age){
        super(name,age);
    }
    @Override
    public void Basketball(){
        System.out.println(getName()+" "+getAge()+" 打篮球");
    }
}
