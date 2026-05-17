package Exception.Test5;

public class NPY {
    private String name;
    private int age;
    public NPY(){}
    public NPY(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        if(!(name.length()>=3&&name.length()<=10)){
            throw new NameFormatException("姓名长度必须在3-10之间");
        }
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(!(age>=18&&age<=35)){
            throw new AgeOutOfBoundsException("年龄必须在18-35岁之间");
        }
        this.age=age;
    }
    @Override
    public String toString(){
        return "NPY{name='"+name+"', age="+age+"}";
    }
}
