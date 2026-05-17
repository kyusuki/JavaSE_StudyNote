package taskFour.Demo1;

public class Test {
    public static void main(String[] args){
        final int a=10;
        //a=20; //报错，final修饰的变量不能再赋值
        System.out.println(a); //10
    }
}
/*
class Fu{
    public final void show(){
        System.out.println("我是父类show方法");
    }
}
class Zi extends Fu{
    @Override
    public void show(){
        System.out.println("我是子类show方法"); //报错，不能重写final修饰的方法
    }
}
*/
/*
final class Fu{
    public void show(){
        System.out.println("我是父类show方法");
    }
}
class Zi extends Fu{ //报错，不能继承final类
    @Override
    public void show(){
        System.out.println("我是子类show方法");
    }
}
*/