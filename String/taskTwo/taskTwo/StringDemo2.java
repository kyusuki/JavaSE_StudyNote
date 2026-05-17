package taskTwo;
import java.util.Scanner;
public class StringDemo2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next(); //abc 是通过new获取的
        String s2="abc"; //是通过直接赋值的
        System.out.println(s1==s2); //false
        sc.close();
    }
}
