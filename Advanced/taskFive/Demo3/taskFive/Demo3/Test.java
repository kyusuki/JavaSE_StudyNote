package taskFive.Demo3;

public class Test {
    public static void main(String[] args){
        Animal r=new Rabit("小白",1);
        r.eat();
        System.out.println();
        Dog d=new Dog("小黄",2);
        d.eat();
        d.swim();
        System.out.println();
        Frog f=new Frog("小蛙",1);
        f.eat();
        f.swim();
    }
}
