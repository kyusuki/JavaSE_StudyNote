package Generic.Test3;

import java.util.ArrayList;

public class test3 {
    public static void main(String[] args){
        ArrayList<String> list1=new ArrayList<>();
        ListUtil.addAll(list1,"aaa","bbb","ccc");
        System.out.println(list1);

        ArrayList<Integer> list2=new ArrayList<>();
        ListUtil.addAll(list2,111,222,333);
        System.out.println(list2);
    }
}
