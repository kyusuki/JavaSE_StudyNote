import java.util.Scanner;
public class 关系符练习 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        /*if(a>b){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }*/
        boolean result=a>b;
        System.out.println(result);
        sc.close();
    }
}
 