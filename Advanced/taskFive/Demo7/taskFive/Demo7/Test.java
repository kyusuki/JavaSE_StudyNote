package taskFive.Demo7;

public class Test {
    public static void main(String[] args){
        ttPlayer ttp=new ttPlayer("Cris Griffin",45);
        ttp.play("table tennis");
        ttp.speak();
        System.out.println();
        ttCoach ttc=new ttCoach("Peter Griffin",16);
        ttc.teach("table tennis");
        ttc.speak();
        System.out.println();
        bkPlayer bkp=new bkPlayer("Meg Griffin",18);
        bkp.play("baskketball");
        System.out.println();
        bkCoach bkc=new bkCoach("Louis Griffin",40);
        bkc.teach("basketball");
    }
}
