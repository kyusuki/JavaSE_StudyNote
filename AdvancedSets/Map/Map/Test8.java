package Map;

import java.util.Comparator;
import java.util.TreeMap;

public class Test8 {
    public static void main(String[] args){
        TreeMap<Integer,String> tm=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        tm.put(123,"zhangsan");
        tm.put(101,"lisi");
        tm.put(259,"wangwu");
        System.out.println(tm);
    }
}
