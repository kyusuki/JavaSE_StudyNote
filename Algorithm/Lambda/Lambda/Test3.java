package Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {
    public static void main(String[] args){
        Integer[] arr={2,3,1,5,7,9,4,8,6};
        Arrays.sort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        //Lambda完整格式
        Arrays.sort(arr,(Integer o1,Integer o2)->{
                return o1-o2;
        });

        //Lambda省略格式1
        Arrays.sort(arr,(o1,o2)->{
                return o1-o2;
        });

        //Lambda省略格式2
        Arrays.sort(arr,(o1,o2)->o1-o2);
        
        System.out.println(Arrays.toString(arr));
    }
}
