package taskThree.Demo2;

public class Test {
    public static void main(String[] args){
        //创建对象（多态方法）
        //Fu f=new Zi();
        Animal a=new Dog();
        
        //调用成员变量，编译看左边，运行也看左边
        System.out.println(a.name); //动物
        
        //调用成员方法，编译看左边，运行看右边
        a.show(); //Dog---show方法
    }
}
class Animal{
    String name="动物";
    public void show(){
        System.out.println("Animal---show方法");
    }
}
class Dog extends Animal{
    String name="狗";
    @Override
    public void show(){
        System.out.println("Dog---show方法");
    }
}

