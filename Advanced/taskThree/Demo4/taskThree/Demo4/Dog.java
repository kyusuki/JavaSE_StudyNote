package taskThree.Demo4;

public class Dog extends Animal{
    public Dog(){}
    public Dog(int age,String color){
        super(age,color);
    }    
    @Override
    public void eat(String something){
        System.out.println(getAge()+"岁"+getColor()+"的大狗叫喜欢吃"+something);
    }
    public void lookHome(){
        System.out.println("它能看家");
    }
}
