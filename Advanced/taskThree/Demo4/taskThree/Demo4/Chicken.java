package taskThree.Demo4;

public class Chicken extends Animal{
    public Chicken(){}
    public Chicken(int age,String color){
        super(age,color);
    }    
    @Override
    public void eat(String something){
        System.out.println(getAge()+"岁"+getColor()+"的叮咚鸡喜欢吃"+something);
    }
    public void layEgg(){
        System.out.println("它能下蛋");
    }
}
