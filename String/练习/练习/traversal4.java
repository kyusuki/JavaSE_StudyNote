package 练习;  //定义一个方法，字符串反转
import java.util.Scanner;
public class traversal4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str=sc.nextLine();
        String result=reverse(str);
        System.out.println("反转后结果");
        System.out.println(result);
        sc.close();
    }
    public static String reverse(String str){
        char[] arr=new char[str.length()];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            arr[i]=c;
        }
        for(int i=0;i<arr.length/2;i++){
            char temp=arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=temp;
        }
        String result="";
        for(int i=0;i<arr.length;i++){
            result=result+arr[i];
        }
        return result;
    }
}
