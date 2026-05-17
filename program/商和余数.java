import java.util.Scanner;
public class 商和余数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int dividend=sc.nextInt();
        int divisor=sc.nextInt();
        int count=0;
        while(dividend>=divisor){
            dividend-=divisor;
            count++;
        }
        System.out.println("商为："+count);
        System.out.println("余数为："+dividend);
        sc.close();
    }
}