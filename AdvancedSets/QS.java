import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class QS {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        int num;
        System.out.println("请输入要排序的整数（输入-1结束）：");
        while((num=sc.nextInt())!=-1){
            list.add(num);
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
        quickSort(arr, 0, arr.length-1);
        System.out.println("排序后的数组为："+Arrays.toString(arr));
        sc.close();
    }
    public static void quickSort(int[] arr,int left,int right){
        int start=left;
        int end=right;
        int pivot=arr[left];
        if(start>end){
            return;
        }
        while(start!=end){
            while(arr[end]>=pivot&&start<end){
                end--;
            }
            while(arr[start]<=pivot&&start<end){
                start++;
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
        arr[left]=arr[start];
        arr[start]=pivot;
        if(start-1>left){
            quickSort(arr,left,start-1); //左递归
        }
        if(start+1<right){
            quickSort(arr,start+1,right); //右递归
        }
    }
}
