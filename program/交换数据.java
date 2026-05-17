import java.util.Scanner;
public class 交换数据 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int []arr=new int[5];
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<5/2;i++){
            int temp=arr[i];
            arr[i]=arr[4-i];
            arr[4-i]=temp;
        }
        for(int i=0;i<5;i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
