package taskEleven;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] args){
        /*
         * public static String toBinaryString(int i)        得到二进制
         * public static String toOctalSting(int i)          得到八进制
         * public static String toHexString(int i)           得到十六进制
         * public static int parseInt(String s)              将字符串类型的整数转成int类型的整数
         */
        String s1=Integer.toBinaryString(100);
        System.out.println(s1); //1100100
        String s2=Integer.toOctalString(100);
        System.out.println(s2); //144
        String s3=Integer.toHexString(100);
        System.out.println(s3); //64
        //将字符串类型的整数转成int类型的整数，很重要，在以后的开发中会经常使用
        //！！！字符串只能是整数，其他字符都会报错！！！
        String s4="1234";
        int i=Integer.parseInt(s4);
        System.out.println(i); //1234

        
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int num=Integer.parseInt(str);
        System.out.println(num);
        sc.close();
    }
}
