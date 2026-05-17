package taskThree.Demo3;

public class Test {
    public static void main(String[] args){
        Dog d=new Dog(2,"土黄色","剩饭剩菜");
        d.eat();
        d.lookHome();
        Person p1=new Person("老李",56);
        p1.keepPet(d,d.getSomething());
        System.out.println("----------------------");
        Cat c=new Cat(3,"橘黄色","鱼头辣妈");
        c.eat();
        c.catchMouse();
        Person p2=new Person("老张",52);
        p2.keepPet(c,c.getSomething());
    }
}
