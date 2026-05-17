package Search;

public class BasicSearch {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        int target=5;
        System.out.println(basicSearch(arr, target));
    }
    public static boolean basicSearch(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }
}
