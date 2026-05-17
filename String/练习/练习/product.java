package 练习;
import java.util.Scanner;
public class product {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请分别输入num1和num2");
        String num1=sc.nextLine();
        String num2=sc.nextLine();
        long a=Long.parseLong(num1);
        long b=Long.parseLong(num2);
        long c=a*b;
        String s=Long.toString(c);
        System.out.println("乘积为="+s);
        sc.close();
    }
}
