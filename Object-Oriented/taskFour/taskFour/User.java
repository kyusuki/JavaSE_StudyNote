package taskFour;

public class User {
    //属性
    private String name;
    private String password;
    private String email;
    private String gender;
    private int age;
    //空参
    public User(){}
    //有参
    public User(String name,String password,String email,String gender,int age){
        this.name=name;
        this.password=password;
        this.email=email;
        this.gender=gender;
        this.age=age;
    }
    //get和set方法
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getGender(){
        return gender;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}
