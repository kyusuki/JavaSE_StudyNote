package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class Test1 {
    public static void main(String[] args){
        Set<String> set=new HashSet<>();
        boolean b1=set.add("aaa");
        boolean b2=set.add("bbb");
        boolean b3=set.add("bbb");
        System.out.println(b1); //true
        System.out.println(b2); //true
        System.out.println(b3); //false，因为set不允许有重复元素
        System.out.println(set); //[aaa, bbb]

        //迭代器遍历
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String str=it.next();
            System.out.print(str+" ");
        }
        System.out.println();

        //增强for遍历
        for(String str:set){
            System.out.print(str+" ");
        }
        System.out.println();

        //匿名内部类遍历
        set.forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.print(s+" ");
            }
        });
        System.out.println();

        //Lambda表达式遍历
        set.forEach((s)->System.out.print(s+" "));
    }
}
