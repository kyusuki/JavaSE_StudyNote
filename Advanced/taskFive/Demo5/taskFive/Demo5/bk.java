package taskFive.Demo5;

public class bk extends People{
    public bk(){}
    public bk(String name,int age){
        super(name,age);
    }
    public void play(String subject){
        System.out.println(getName()+" "+getAge()+" 打"+subject);
    }
    public void teach(String subject){
        System.out.println(getName()+" "+getAge()+" 教打"+subject);
    }
}
