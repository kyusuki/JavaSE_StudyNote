import java.util.Scanner;
public class 算数练习 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int a=num/100; //百位
        int b=num%100/10; //十位
        int c=num%10; //个位
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        sc.close();
    }
}
