package taskTwo.Demo2;

public class Test {
    public static void main(String[] args){
        westPerson wp=new westPerson();
        wp.lunch();
        System.out.println("-----------------");
        eastPerson ep=new eastPerson();
        ep.lunch();
    }
}
class Person{
    public void eat(){
        System.out.println("吃米饭");
    }
    public void drink(){
        System.out.println("喝热水");
    }
}
class westPerson extends Person{
    public void lunch(){
        this.eat(); //吃快餐
        this.drink(); //喝可乐
        
        super.eat(); //吃米饭
        super.drink(); //喝热水
    }
    @Override
    public void eat(){
        System.out.println("吃快餐");
    }
    @Override
    public void drink(){
        System.out.println("喝可乐");
    }
}
class eastPerson extends Person{
    public void lunch(){
        this.eat(); //吃米饭
        this.drink(); //喝热水

        super.eat(); //吃米饭
        super.drink(); //喝热水
    }
}