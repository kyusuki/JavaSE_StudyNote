package Search;

public class InterpolationSearch {
    public static void main(String[] args){
        int[] arr={12,23,34,45,56,67,78,89};
        int target=67;
        System.out.println(interpolationSearch(arr, target));
    }
    public static int interpolationSearch(int[] arr,int target){
        int mid;
        int max=arr.length-1,min=0;
        while(min<=max){
            mid=min+((target-arr[min])*(max-min))/(arr[max]-arr[min]);
            if(target<arr[mid]){
                max=min-1;
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
