package taskTwo.Demo5;

public class Worker {
    private String id;
    private String name;
    private double wage;
    public Worker(){}
    public Worker(String id,String name,double wage){
        this.id=id;
        this.name=name;
        this.wage=wage;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setWage(double wage){
        this.wage=wage;
    }
    public double getWage(){
        return wage;
    }
    public void work(){
        System.out.println("工作");
    }
    public void eat(){
        System.out.println("吃饭");
    }
}
