package 综合案例1;

public class GameTest1 {
    public static void main(String[] args){
        //创造角色
        Role1 r1=new Role1("特朗普",100,'男');
        Role1 r2=new Role1("哈里斯",100,'女');
        r1.showRole();
        r2.showRole();
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
