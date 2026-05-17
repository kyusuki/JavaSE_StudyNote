package 练习;
import java.util.Scanner;
import java.util.Random;
public class disrupt {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String A=sc.nextLine();
        System.out.println("打乱后字符串为"+" "+f(A));
        sc.close();
    }
    public static String f(String A){
        Random r=new Random();
        char[] c=A.toCharArray();
        for(int i=0;i<A.length();i++){
            int index=r.nextInt(A.length());
            char temp=c[i];
            c[i]=c[index];
            c[index]=temp;
        }
        String s=new String(c);
        return s;
    }
}
