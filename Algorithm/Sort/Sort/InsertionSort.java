package Sort;

public class InsertionSort {
    public static void main(String[] args){        
        int[] arr={19,27,12,67,3,19,48,55,31,6};
        int[] sortedArr=insertionSort(arr);
        for(int i=0;i<sortedArr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }
    }
    public static int[] insertionSort(int[] arr){
        int startIndex=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
                startIndex=i+1;
                break;
            }
        }
        for(int i=startIndex;i<arr.length;i++){
            int j=i;
            while(j>0&&arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
        return arr;
    }
}
