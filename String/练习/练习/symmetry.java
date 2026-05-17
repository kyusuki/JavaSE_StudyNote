package 练习;
import java.util.Scanner;
public class symmetry {
    public static void main(String[] args){
        //使用StringBuilder的场景
        //1.字符串拼接
        //2.字符串反转

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String str1=sc.nextLine();
        String str2=new StringBuilder(str1).reverse().toString();
        if(str1.equals(str2)){
            System.out.println(str1+"是对称字符串");
        }
        else{
            System.out.println(str1+"不是对称字符串");
        }
        sc.close();
    }
}
