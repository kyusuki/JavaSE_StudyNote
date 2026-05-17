public class QuickSort {
    public static void main(String[] args){
        long time1=System.currentTimeMillis();
        int[] arr={12,34,11,53,2,67,13,86,6,122,64,10,333,100,23,61,99};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        long time2=System.currentTimeMillis();
        double result=(time2-time1)/1000.0;
        System.out.println(result+" 秒");
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
