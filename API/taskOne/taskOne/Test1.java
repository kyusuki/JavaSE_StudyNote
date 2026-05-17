package taskOne;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isPrime(n));
        sc.close();
    }
    public static boolean isPrime(int n){
        int count=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            count++;
            if(n%i==0){
                return false;
            }
        }
        System.out.println(count);
        return true;
    }
}
