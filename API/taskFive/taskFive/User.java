package taskFive;
import java.util.StringJoiner;
/*
 * Cloneable
 * 如果一个接口里没有抽象方法，表示当前接口是一个标记性接口
 * 现在Cloneable表示一旦实现，那么当前类的对象可以被克隆
 * 如果没有实现，当前类的对象就不能克隆
 */
public class User implements Cloneable{
    private int id;
    private String username;
    private String password;
    private String path;
    private int[] date;
    public User(){}
    public User(int id,String username,String password,String path,int[] date){
        this.id=id;
        this.username=username;
        this.password=password;
        this.path=path;
        this.date=date;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
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
    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path=path;
    }
    public int[] getDate(){
        return date;
    }
    public void setDate(int[] date){
        this.date=date;
    }
    public String toString(){
        return id+" "+username+" "+password+" "+path+" "+arrToString();
    }
    public String arrToString(){
        StringJoiner sj=new StringJoiner(",","[","]");
        for(int i=0;i<date.length;i++){
            sj.add(date[i]+"");
        }
        return sj.toString();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        /*
         * 调用父类的clone方法
         * 相当于让Java帮助克隆一个对象，并把克隆之后的对象返回出去
         */
        return super.clone();
    }
}
