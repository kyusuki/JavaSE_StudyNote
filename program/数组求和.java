/*import java.util.Scanner;
public class 数组求和 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int []arr=new int[10];
        int sum=0;
        double avg=0.0;
        int count=0;
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<10;i++){
            sum+=arr[i];
        }
        avg=sum/10.0;
        for(int i=0;i<10;i++){
            if(arr[i]<avg){
                count++;
            }
        }
        System.out.println("和为："+sum);
        System.out.println("平均值为："+avg);
        System.out.println("小于平均值的个数为："+count);
    }
}*/

import java.util.Random;
public class 数组求和{
    public static void main(String[] args){
        int []arr=new int[10];
        Random random=new Random();
        for(int i=0;i<10;i++){
            arr[i]=random.nextInt(100)+1;
        }
        for(int i=0;i<10;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        int sum=0,count=0;
        double avg=0.0;
        for(int i=0;i<10;i++){
            sum+=arr[i];
        }
        avg=sum/10.0;
        for(int i=0;i<10;i++){
            if(arr[i]<avg){
                count++;
            }
        }
        System.out.println("和为："+sum);
        System.out.println("平均值为："+avg);
        System.out.println("小于平均值的个数为："+count);
    }
}