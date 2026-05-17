package taskEleven;
import java.util.Scanner;
public class Test6 {
    public static int yu=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        StringBuilder str=new StringBuilder();
        while(num!=0){
            yu=num%2;
            str.append(yu);
            num=num/2;
        }
        System.out.println(str.reverse().toString());
        sc.close();
    }
}
