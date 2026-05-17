package 综合案例1;
import java.util.Random;
public class Role {
    private String name;
    private int blood;
    public Role(){}
    public Role(String name,int blood){
        this.name=name;
        this.blood=blood;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setBlood(int blood){
        this.blood=blood;
    }
    public int getBlood(){
        return blood;
    }
    
    
    //攻击 谁攻击谁？
    //Role r1=new Role();
    //Role r2=new Role();
    //r1.attack(r2);
    //方法调用这去攻击参数
    public void attack(Role r){
        //计算伤害
        Random r1=new Random();
        int damage=r1.nextInt(20)+1;
        //剩余血量
        int remain=r.getBlood()-damage;
        //血量为负时，修改为0
        remain=remain<0?0:remain;
        //修改被攻击者的血量
        r.setBlood(remain);
        //this表示方法的调用者
        System.out.println(this.getName()+"攻击了"+r.getName()+",造成了"+damage+"点伤害"+"，"+r.getName()+"剩余"+r.getBlood()+"点血量");
    }
}
