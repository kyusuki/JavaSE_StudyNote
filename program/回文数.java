/*import java.util.Scanner;
public class 回文数 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        for(int i=1;i<=x;i++){
            int a=i;
            int temp=0;
            while(a>0){
                int b=a%10;
                temp=temp*10+b;
                a/=10;
            }
            if(i==temp){
                System.out.println(i);
            }
        }
    }
}*/

import java.util.Scanner;
public class 回文数{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(f(x));
        sc.close();
    }
    public static boolean f(int x){
        int a=x;
        int temp=0;
        while(a>0){
            int b=a%10;
            temp=temp*10+b;
            a/=10;
        }
        if(x==temp){
            return true;
        }
        return false;
    }
}
