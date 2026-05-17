package 综合案例1;

public class GameTest {
    public static void main(String[] args){
        //创造角色
        Role r1=new Role("高音哥",100);
        Role r2=new Role("波澜哥",100);
        //攻击,回合制
        while(true){
            r1.attack(r2);
            if(r2.getBlood()==0){
                System.out.println(r1.getName()+"击败了"+r2.getName());
                break;
            }
            r2.attack(r1);
            if(r1.getBlood()==0){
                System.out.println(r2.getName()+"击败了"+r1.getName());
                break;
            }
            System.out.println("-----------------");
        }
    }
}
