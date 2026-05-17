package taskOne;
import java.util.Scanner;
public class ScannerDemo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个小数");
        double d=sc.nextDouble();
        System.out.println(d);
        sc.close();
    }
}