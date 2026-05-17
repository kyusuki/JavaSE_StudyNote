package 练习; //统计字符串中大写字母，小写字母，数字的个数
import java.util.Scanner;
public class traversal2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串");  //Im Gao,My grade is 520
        String str=sc.next();  //如果用nextLine(),则允许使用空格
        int count1=0,count2=0,count3=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c>='A'&&c<='Z'){  //Character.isUpperCase(c)
                count1++;
            }
            else if(c>='a'&&c<='z'){  //Character.isLowerCase(c)
                count2++;
            }
            else if(c>='0'&&c<='9'){  //Character.isDigit(c)
                count3++;
            }
        }
        System.out.println("大写字母个数："+count1);
        System.out.println("小写字母个数："+count2); 
        System.out.println("数字个数："+count3);
        sc.close();
    }
}
