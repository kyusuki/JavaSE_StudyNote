package taskOne.Demo1;

public class Student {
    private String name;
    private int age;
    private String gender;
    static String teacherName; //静态变量，所有对象共享
    public Student(){}
    public Student(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
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
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void study(){
        System.out.println(name+"正在学习");
    }
    public void showInfo(){
        System.out.println(name+" "+age+" "+gender+" "+teacherName);
    }
}
