package Sort;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr={27,12,67,3,19,48,55,31,6};
        int[] sortedArr=bubbleSort(arr);
        for(int i=0;i<sortedArr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }
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
