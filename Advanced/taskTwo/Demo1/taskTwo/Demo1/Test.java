package taskTwo.Demo1;

public class Test {
    public static void main(String[] args){
        Zi z=new Zi(); //创建子类对象
        z.show(); //调用子类方法
    }
}
class Fu{
    String name="Fu";
}
class Zi extends Fu{
    String name="Zi";
    public void show(){
        String name="ziShow";
        System.out.println(name); //ziShow
        System.out.println(this.name); //Zi
        System.out.println(super.name); //Fu
    }
}
