package Generic.Test6;

import java.util.ArrayList;

public class test4 {
    public static void main(String[] args){
        ArrayList<dog> list1=new ArrayList<>();
        ArrayList<cat> list2=new ArrayList<>();
        list1.add(new teddy("小棕",2));
        list1.add(new husky("小灰", 3));
        list2.add(new persian("小白",1));
        list2.add(new civet("小花", 1));
        keepPet(list1);
    }
    public static void keepPet(ArrayList<? extends dog> list){
        for(int i=0;i<list.size();i++){
            dog d=list.get(i);
            d.eat();
        }
    }
}
abstract class animal{
    private String name;
    private int age;
    public animal(){}
    public animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public abstract void eat();
}
abstract class cat extends animal{
    public cat(){}
    public cat(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"，正在吃");
    }
}
abstract class dog extends animal{
    public dog(){}
    public dog(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"，正在吃"+"，边吃边");
    }
}
class persian extends cat{
    public persian(){}
    public persian(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的波斯猫"+"，正在吃小饼干");
    }
}
class civet extends cat{
    public civet(){}
    public civet(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的狸花猫"+"，正在吃鱼");
    }
}
class teddy extends dog{
    public teddy(){}
    public teddy(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的泰迪"+"，正在吃骨头"+"，边吃边蹭");
    }
}
class husky extends dog{
    public husky(){}
    public husky(String name,int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的哈士奇"+"，正在吃骨头"+"，边吃边拆家");
    }
}
