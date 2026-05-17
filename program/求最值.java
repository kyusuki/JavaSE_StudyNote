import java.util.Scanner;
public class 求最值 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int []arr=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=sc.nextInt();
        }
        int max=arr[0],min=arr[0];
        for(int i=0;i<10;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            else if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("最大值为："+max);
        System.out.println("最小值为："+min);
        sc.close();
    }
}
