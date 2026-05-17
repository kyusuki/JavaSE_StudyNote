import java.util.ArrayList;
import java.util.Scanner;

public class SearchSort {
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
        for(int j=0;j<list.size();j++){
            arr[j]=list.get(j);
        }
        arr=searchSort(arr);
        for(int j=0;j<list.size();j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
        long time2=System.currentTimeMillis();
        double result=(time2-time1)/1000.0;
        System.out.println(result+" 秒");
        sc.close();
    }
    public static int[] searchSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
