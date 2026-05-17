package Test1;

public class Girl {
    private String name;
    private int age;
    private double height;
    public Girl(){}
    public Girl(String name,int age,double height){
        this.name=name;
        this.age=age;
        this.height=height;
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
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height=height;
    }
    @Override
    public String toString(){
        String str="name:"+name+" age:"+age+" height:"+height;
        return str;
    }
}