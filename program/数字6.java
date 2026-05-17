import java.util.Scanner;
public class 数字6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(a==6||b==6){
            System.out.println("true");
        }
        else if((a+b)%6==0){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
        sc.close();
    }
}
 