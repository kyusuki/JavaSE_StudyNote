//1.导入包
import java.util.Scanner;
public class 键盘录入{
    public static void main(String[] args){
        //2.创建对象
        Scanner sc=new Scanner(System.in);
        //3.提示用户输入数据
        System.out.println("请输入一个整数");
        //4.接收数据
        int a=sc.nextInt();
        //5.输出数据
        System.out.println(a);
        sc.close();
    }
}