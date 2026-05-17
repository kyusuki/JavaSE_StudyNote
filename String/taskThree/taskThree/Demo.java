package taskThree;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args){
        //链式编程
        int len=getString().substring(1).replace("A","B").length();
        System.out.println(len);
    }
    public static String getString(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String str=sc.nextLine();
        sc.close();
        return str;
    }
}
