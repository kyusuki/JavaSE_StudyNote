package Sort;

public class SelectionSort {
    public static void main(String[] args){
        int[] arr={27,12,67,3,19,48,55,31,6};
        int[] sortedArr=selectionSort(arr);
        for(int i=0;i<sortedArr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }
    }
    public static int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
}
