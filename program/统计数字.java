import java.util.Scanner;
public class 统计数字 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=0;
        for(int i=a;i<b;i++){
            if(i%3==0&&i%5==0){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
