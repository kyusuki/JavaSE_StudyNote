package Search;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr={12,23,34,45,56,67,78,89};
        int target=34;
        System.out.println(binarySearch(arr, target));
    }
    public static int binarySearch(int[] arr,int target){
        int mid;
        int max=arr.length-1,min=0;
        while(min<=max){
            mid=(max-min)/2+min;
            if(target<arr[mid]){
                max=mid-1;
                continue;
            }
            if(target>arr[mid]){
                min=mid+1;
                continue;
            }
            if(target==arr[mid]){
                return mid;
            }
        }
        return -1;
    }
}
