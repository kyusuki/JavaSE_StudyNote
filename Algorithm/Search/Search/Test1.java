package Search;
import java.util.ArrayList;
public class Test1 {
    public static void main(String[] args){
        int[] arr={12,34,56,67,76,34,23,78};
        int target=34;
        System.out.println(basicSearch(arr, target));
    }
    public static ArrayList<Integer> basicSearch(int[] arr,int target){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                list.add(i);
                continue;
            }
        }
        return list;
    }
}
