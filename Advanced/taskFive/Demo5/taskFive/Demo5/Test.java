package taskFive.Demo5;

public class Test {
    public static void main(String[] args){
        ttPlayer ttp=new ttPlayer("张三",18);
        ttp.play("乒乓球");
        ttp.speak();
        System.out.println();
        bkPlayer bkp=new bkPlayer("李四",25);
        bkp.play("篮球");
        System.out.println();
        ttCoach ttc=new ttCoach("王五",36);
        ttc.teach("乒乓球");
        ttc.speak();
        System.out.println();
        bkCoach bkc=new bkCoach("赵六",42);
        bkc.teach("篮球");
    }
}
