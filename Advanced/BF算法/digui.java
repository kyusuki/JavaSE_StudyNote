import java.util.Scanner;
public class digui{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long num=sc.nextLong();
        System.out.println(f(num));
        sc.close();
    }
    public static long f(long n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
} 