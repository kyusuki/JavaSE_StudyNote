import java.util.Scanner;
import java.util.Random;
public class 猜数字 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random random=new Random(); //创建随机数对象
        int n=random.nextInt(100)+1; //生成1-100的随机数
        int guess=0;
        System.out.println("请输入一个1-100的数字");
        while(guess!=n){
            guess=sc.nextInt();
            if(guess<n){
                System.out.println("猜的数字小了");
                continue;
            }
            if(guess>n){
                System.out.println("猜的数字大了");
                continue;
            }
            System.out.println("你猜对了");
            break;
        }
        sc.close();
    }
}
