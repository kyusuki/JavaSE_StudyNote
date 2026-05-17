package Student2;

public class student {
    private int id;
    private String username;
    private int password;
    public student(){}
    public student(int id,String username,int password){
        this.id=id;
        this.username=username;
        this.password=password;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(int password){
        this.password=password;
    }
    public int getPassword(){
        return password;
    }
}
