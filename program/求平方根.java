import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class 求平方根 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double x=sc.nextDouble();
        double y=Math.sqrt(x);
        int scale=3;
        DecimalFormat df=new DecimalFormat("0."+"0".repeat(scale));
        System.out.println("平方根="+df.format(y));
        sc.close();
    }
}
