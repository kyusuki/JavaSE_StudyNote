import java.util.Scanner;
public class 方法 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        double r=sc.nextDouble();
        int c=f(a,b);
        System.out.println("长方形周长为："+c);
        double s=g(r);
        System.out.println("圆的面积为："+s);
        sc.close();
    }
    public static int f(int a,int b){
        int c=(a+b)*2;
        return c;
    }
    public static double g(double r){
        double s=3.14*r*r;
        return s;
    }
}
