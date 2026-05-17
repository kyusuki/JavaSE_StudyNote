package Stream.Test5.test3;

public class Actor {
    private String NameAge;
    public Actor(){}
    public Actor(String NameAge){
        this.NameAge=NameAge;
    }
    public String getNameAge(){
        return NameAge;
    }
    public void setNameAge(String NameAge){
        this.NameAge=NameAge;
    }
    @Override
    public String toString(){
        return NameAge;
    }
}
