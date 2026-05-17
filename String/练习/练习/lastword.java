package 练习;
import java.util.Scanner;
public class lastword {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String s=sc.nextLine();
        String last="";
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                last=s.substring(i+1);
                break;
            }
        }
        System.out.println("最后一个单词是“"+last+"”,长度为"+last.length());
        sc.close();
    }
}
