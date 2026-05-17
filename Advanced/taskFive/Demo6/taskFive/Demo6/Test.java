package taskFive.Demo6;

public class Test {
    public static void main(String[] args){
        Tt ttp=new ttPlayer("张三",19);
        ttp.TableTennis();
        ttp.speak();
        System.out.println();
        Bk bkp=new bkPlayer("李四",26);
        bkp.Basketball();
        System.out.println();
        Tt ttc=new ttCoach("王五",36);
        ttc.TableTennis();
        ttc.speak();
        System.out.println();
        Bk bkc=new bkCoach("赵六",45);
        bkc.Basketball();
    }
}
