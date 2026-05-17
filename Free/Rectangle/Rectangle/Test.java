package Rectangle;
import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double l=sc.nextDouble();
        double w=sc.nextDouble();
        Class r=new Class(l,w);
        System.out.println("面积为"+r.getArea());
        System.out.println("周长为"+r.getPerimeter());
        sc.close();
    }
}
