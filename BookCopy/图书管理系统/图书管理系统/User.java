package 图书管理系统;

public class User {
    private String username;
    private String password;
    private String id;
    private String phone;
    private int userType; //用户类型 0：普通用户 1：管理员
    public User(){}
    public User(String username,String password,String id,String phone,int userType){
        this.username=username;
        this.password=password;
        this.id=id;
        this.phone=phone;
        this.userType=userType;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setUserType(int userType){
        this.userType=userType;
    }
    public int getUserType(){
        return userType;
    }
}
