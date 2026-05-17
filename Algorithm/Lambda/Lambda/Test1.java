package Lambda;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args){
        Integer[] arr={2,3,1,5,7,9,4,8,6};
        Arrays.sort(arr,(Integer o1,Integer o2)->{
            return o2-o1;
        });
        System.out.println(Arrays.toString(arr));
    }
}
