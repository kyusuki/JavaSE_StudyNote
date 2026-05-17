package taskOne.Demo4;

public class Test {
    public static void main(String[] args){
        PuppetCat p=new PuppetCat();
        System.out.println("布偶猫");
        p.eat();
        p.drink();
        p.catchM();
        System.out.println();
        CivetCat c=new CivetCat();
        System.out.println("狸花猫");
        c.eat();
        c.drink();
        c.catchM();
        System.out.println();
        Husky h=new Husky();
        System.out.println("哈士奇");
        h.eat();
        h.drink();
        h.watch();
        h.play();
        System.out.println();
        Teddy t=new Teddy();
        System.out.println("泰迪");
        t.eat();
        t.drink();
        t.watch();
        t.play();
    }
}
