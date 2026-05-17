package taskThree.Demo3;

public class Person {
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void keepPet(Dog d,String something){
        System.out.println("年龄为"+getAge()+"岁的"+getName()+"正在用"+something+"喂养"+d.getAge()+"岁"+d.getColor()+"的大狗叫");
    }
    public void keepPet(Cat c,String something){
        System.out.println("年龄为"+getAge()+"岁的"+getName()+"正在用"+something+"喂养"+c.getAge()+"岁"+c.getColor()+"的哈吉米");
    }
}
