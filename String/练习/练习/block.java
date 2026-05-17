package 练习;
import java.util.Scanner;
public class block {
    public static void main(String[] args){
        //String substring(int beginIndex,int endIndex) //截取，包头不包尾，只有返回值才是截取的部分
        //String substring(int beginIndex) //截取到末尾
        Scanner sc=new Scanner(System.in);
        String phonenum=sc.nextLine(); //13112349468
        String start=phonenum.substring(0,3);
        //System.out.println(start); //131
        String end=phonenum.substring(7);
        //System.out.println(end); //9468
        String result=start+"****"+end;
        System.out.println(result);
        sc.close();
    }
}
