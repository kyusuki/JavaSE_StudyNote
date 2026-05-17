import java.util.Scanner;
public class 评委打分 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[6];
        for(int i=0;i<6;i++){
            System.out.println("请输入第"+(i+1)+"个评委打分");
            arr[i]=sc.nextInt();
        }
        double avg=f(arr);
        System.out.println("该选手最终成绩为："+avg);
    }
    public static double f(int[] arr){
        int max=arr[0],min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        int sum=0;
        double avg=0.0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=max&&arr[i]!=min){
                sum+=arr[i];
            }
        }
        avg=sum/(arr.length-2.0);
        return avg;
    }
}
