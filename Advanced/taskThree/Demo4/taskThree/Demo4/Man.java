package taskThree.Demo4;

public class Man {
    private String name;
    private int age;
    public Man(){}
    public Man(String name,int age){
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
    /*
    public void keepPet(Dog d,String something){
        System.out.println(getAge()+"岁的"+getName()+"养了一只"+d.getAge()+"岁"+d.getColor()+"的大狗叫");
        d.eat(something);
    }
    public void keepPet(Chicken c,String something){
        System.out.println(getAge()+"岁的"+getName()+"养了一只"+c.getAge()+"岁"+c.getColor()+"的叮咚鸡");
        c.eat(something);
    }
    */

    public void keepPet(Animal a,String something){
        if(a instanceof Dog d){
            System.out.println(getAge()+"岁的"+getName()+"养了一只"+a.getAge()+"岁"+a.getColor()+"的大狗叫");
            d.eat(something);
        }
        else if(a instanceof Chicken c){
            System.out.println(getAge()+"岁的"+getName()+"养了一只"+a.getAge()+"岁"+a.getColor()+"的叮咚鸡");
            c.eat(something);
        }
    }
}
