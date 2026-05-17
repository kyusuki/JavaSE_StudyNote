package Arrays;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args){
        //toString
        int[] arr={1,2,3,4,5,7,8,9};
        System.out.println(Arrays.toString(arr)); //[1, 2, 3, 4, 5, 7, 8, 9]
        
        //binarySearch
        System.out.println(Arrays.binarySearch(arr, 5)); //4
        //如果数组中不存在该元素，则返回-（插入点）-1
        System.out.println(Arrays.binarySearch(arr, 6)); //-6

        //copyOf
        int[] arr1=Arrays.copyOf(arr, 8);
        System.out.println(Arrays.toString(arr1)); //[1, 2, 3, 4, 5, 7, 8, 9]

        //copyOfRange
        int[] arr2=Arrays.copyOfRange(arr1, 2, 7); //包头不包尾，包左不包右
        System.out.println(Arrays.toString(arr2)); //[3, 4, 5, 7, 8]

        //fill
        Arrays.fill(arr1, 6);
        System.out.println(Arrays.toString(arr1)); //[6, 6, 6, 6, 6, 6, 6, 6]

        //sort
        int[] arr3={9,5,7,2,8,1,3,6,4};
        Arrays.sort(arr3);
        System.out.println(Arrays.toString(arr3)); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
