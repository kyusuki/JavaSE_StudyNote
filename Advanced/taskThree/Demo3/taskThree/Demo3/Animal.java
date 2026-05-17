package taskThree.Demo3;

public class Animal {
    private int age;
    private String color;
    private String something;
    public Animal(){}
    public Animal(int age,String color,String something){
        this.age=age;
        this.color=color;
        this.something=something;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    public void setSomething(String something){
        this.something=something;
    }
    public String getSomething(){
        return something;
    }
    public void eat(){
        System.out.println("它喜欢吃"+getSomething());
    }
}
