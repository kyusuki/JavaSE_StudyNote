package 综合案例2;

public class Girlfrident {
    private String name;
    private int age;
    private String sex;
    private String interest;
    public Girlfrident(){}
    public Girlfrident(String name,int age,String sex,String interest){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.interest=interest;
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
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getSex(){
        return sex;
    }
    public void setInterest(String interest){
        this.interest=interest;
    }
    public String getInterest(){
        return interest;
    }
}
