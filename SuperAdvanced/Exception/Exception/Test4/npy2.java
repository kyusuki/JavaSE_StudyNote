package Exception.Test4;

public class npy2 {
    private String name;
    private int age;
    public npy2(){}
    public npy2(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(!(name.length()>=3&&name.length()<=10)){
            throw new RuntimeException("姓名长度必须在3-10位之间");
        }
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(!(age>=18&&age<=35)){
            throw new RuntimeException("年龄必须在18-35岁之间");
        }
        this.age=age;
    }
}
