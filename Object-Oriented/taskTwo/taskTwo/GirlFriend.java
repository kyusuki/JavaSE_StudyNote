package taskTwo;

public class GirlFriend {
    //属性
    private String name;
    private int age;
    private String BWH;
    
    //--set方法--
    //this关键字用法
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setBWH(String BWH){
        this.BWH=BWH;
    }
    //一般用法
    /*public void setName(String n){
        name=n;
    }
    public void setAge(int n){
        if(n>=18&&n<=35){
            age=n;
        }
        else{
            System.out.println("年龄错误");
        }
    }
    public void setBWH(String n){
        BWH=n;
    }*/
    
    //--get方法--
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBWH(){
        return BWH;
    }
    
    //行为
    public void sleep(){
        System.out.println("女朋友在睡觉");
    }
    public void eat(){
        System.out.println("女朋友在吃饭");
    }
}
