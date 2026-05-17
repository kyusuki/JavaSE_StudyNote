import java.util.Scanner;
public class 小明的礼物 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int score=sc.nextInt();
        if(score>=90){
            System.out.println("奖励一辆车");
        }
        else if(score>=80&&score<90){
            System.out.println("奖励一个飞机");
        }
        else if(score>=70&&score<80){
            System.out.println("奖励一个火箭");
        }
        else{
            System.out.println("打一顿");
        }
        sc.close();
    }
}