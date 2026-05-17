package PockGame.Game.GUI.Information;

public class User {
    private String username;
    private String password;
    public User(){}
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||getClass()!=obj.getClass()){
            return false;
        }
        User user=(User) obj;
        return username.equals(user.username)&&password.equals(user.password);
    }
}
