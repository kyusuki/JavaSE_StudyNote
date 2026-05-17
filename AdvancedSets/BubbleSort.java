import java.util.Scanner;
import java.util.ArrayList;

public class BubbleSort {
    public static void main(String[] args){
        long time1=System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while(true){
            int n=sc.nextInt();
            if(n==-1){
                break;
            }
            list.add(n);
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        arr=bubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        long time2=System.currentTimeMillis();
        double result=(time2-time1)/1000.0;
        System.out.println(result+" 秒");
        sc.close();
    }
    public static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}