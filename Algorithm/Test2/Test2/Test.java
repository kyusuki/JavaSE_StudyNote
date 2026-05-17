package Test2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int month=sc.nextInt();
        System.out.println("第"+month+"个月有"+f(month)+"对兔子");
        sc.close();
    }
    public static int f(int month){
        if(month<=0){
            return 0;
        }
        if(month<=2){
            return 1;
        }
        return f(month-1)+f(month-2);
    }
}
