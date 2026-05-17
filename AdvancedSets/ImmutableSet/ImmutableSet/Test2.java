package ImmutableSet;

import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public static void main(String[] args){
        Set<String> set=Set.of("aaa","bbb","ccc","ddd");
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String s=it.next();
            System.out.print(s+" ");
        }
        System.out.println();
        /*
         * 不可变集合不能进行添加，删除，修改操作
         * set.add("eee");
         * set.remove("bbb");
         * set.set(1,"eee");
         * 
         * 细节：
         * 当获取一个不可变的Set集合时，里面的参数必须要保证唯一性
         */
        System.out.println(set);
    }
}
