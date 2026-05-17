package taskFive.Demo6;

public abstract class Tt extends Person implements Speak{
    public Tt(){}
    public Tt(String name,int age){
        super(name,age);
    }
    public abstract void TableTennis();
    @Override
    public void speak(){
        System.out.println("说英语");
    }
}
