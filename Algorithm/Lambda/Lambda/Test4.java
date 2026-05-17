package Lambda;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args){
        String[] arr={"aa","aaaa","aaa","a"};
        Arrays.sort(arr,(o1,o2)->o1.length()-o2.length());
        System.out.println(Arrays.toString(arr));
    }
}
