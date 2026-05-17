import java.util.Scanner;
public class 数字加密 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个四位数：");
        int num=sc.nextInt();
        int[] arr1=new int[4];
        arr1[0]=num/1000;
        arr1[1]=(num/100)%10;
        arr1[2]=(num/10)%10;
        arr1[3]=num%10;
        int[] arr2=f(arr1);
        System.out.print("加密后的数字为：");
        for(int i=0;i<4;i++){
            System.out.print(arr2[i]);
        }
        sc.close();
    }
    public static int[] f(int[] arr1){
        int[] arr2=new int[4];
        for(int i=0;i<4;i++){
            arr2[i]=(arr1[i]+5)%10;
        }
        for(int i=0;i<4/2;i++){
            int temp=arr2[i];
            arr2[i]=arr2[3-i];
            arr2[3-i]=temp;
        }
        return arr2;
    }
}
