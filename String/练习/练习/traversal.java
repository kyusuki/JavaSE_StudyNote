package 练习;
import java.util.Scanner;
public class traversal {
    public static void main(String[] args){
        //public char charAt(int index)  根据索引返回字符
        //public int length()  返回此字符串的长度
        
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str=sc.next();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            System.out.print(c+" ");
        }
        sc.close();
    }
}
