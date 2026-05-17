package 综合案例2;
import java.util.Scanner;
public class 补充 {
    public static void main(String[] args){
        //键盘录入 两套体系不能混用
        //第一套体系
        //nextInt(); 接收整数
        //nextDouble(); 接收小数
        //next(); 接收字符串
        //遇到空格，制表符，回车就停止接收，此符号其后的不再接收
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        double n2=sc.nextDouble();
        String s1=sc.next();
        System.out.println(n1+" "+n2+" "+s1);
        
        //第二套体系
        //nextLine(); 接收字符串
        //可以接收空格，制表符，遇到回车才停止接收
        String s2=sc.nextLine();
        System.out.println(s2);
        sc.close();
    }
}
