package taskTwo.Demo3;

public class Test {
    public static void main(String[] args){
        Husky h=new Husky();
        h.eat();
        h.drink();
        h.watch();
        h.play();
        System.out.println("-------");
        Shapi s=new Shapi();
        s.eat();
        s.drink();
        s.watch();
        System.out.println("-------");
        Pastoral p=new Pastoral();
        p.eat();
        p.drink();
        p.watch();
    }
}
class Dog{
    public void eat(){
        System.out.println("吃狗粮");
    }
    public void drink(){
        System.out.println("喝水");
    }
    public void watch(){
        System.out.println("看家");
    }
}
class Husky extends Dog{
    public void play(){
        System.out.println("拆家");
    }
}
class Shapi extends Dog{
    @Override
    public void eat(){
        super.eat();
        System.out.println("吃骨头");
    }
}
class Pastoral extends Dog{
    @Override
    public void eat(){
        System.out.println("吃剩饭");
    } 
}
