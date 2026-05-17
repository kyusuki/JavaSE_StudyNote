package Sort;

public class QuickSort {
    public static void main(String[] args){
        //比基准数小的数放在基准数的左边
        //比基准数大的数放在基准数的右边
        int[] arr={6,1,2,7,9,3,4,5,10,8};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void quickSort(int[] arr,int i,int j){
        int start=i;
        int end=j;
        //出口
        if(start>end){
            return;
        }
        int pivot=arr[i];
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
        int temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
        quickSort(arr, i, start-1);
        quickSort(arr, start+1, j);
    }
}
