package 升级版;

public class User {
    private String username;
    private String password;
    private String id;
    private String phone;
    public User(){}
    public User(String username,String password,String id,String phone){
        this.username=username;
        this.password=password;
        this.id=id;
        this.phone=phone;
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
}
