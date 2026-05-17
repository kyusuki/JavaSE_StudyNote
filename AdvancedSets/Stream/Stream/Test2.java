package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args){
        /*
         * default Stream<E> stream()                     单列集合，Collection中的默认方法
         * 无                                             双列集合，无法直接使用stream流
         * public static<T> Stream<T> stream(T[] array)   数组，Arrays工具类中的静态方法
         * public static<T> Stream<T> of(T...values)      一堆零散的数据，Stream接口中的静态方法
         */

        //单列集合
        ArrayList<String> list1=new ArrayList<>();
        Collections.addAll(list1,"aaa","bbb","ccc","ddd");
        //获取流水线
        Stream<String> stream1=list1.stream();
        //使用终结方法进行遍历操作
        stream1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.print(s+" ");
            }
        });
        //或者链式表达式
        System.out.println();
        list1.stream().forEach(s->System.out.print(s+" "));

        System.out.println();

        //双列集合
        /*
         * 注意，双列集合无法直接使用stream流
         * 需先将双列集合转化为set这种单列集合，再使用stream流
         */ 
        HashMap<String,Integer> map1=new HashMap<>();
        map1.put("aaa",111);
        map1.put("bbb",222);
        map1.put("ccc",333);
        map1.put("ddd",444);
        //双列集合转为Set集合
        Set<Map.Entry<String,Integer>> set1=map1.entrySet();
        Stream<Map.Entry<String,Integer>> stream2=set1.stream();
        //使用stream流进行终结操作遍历操作
        stream2.forEach(new Consumer<Map.Entry<String,Integer>>() {
            @Override
            public void accept(Map.Entry<String,Integer> e){
                System.out.print(e.getKey()+":"+e.getValue()+" ");
            }
        });
        //链式表达式
        System.out.println();
        set1.stream().forEach(e->System.out.print(e.getKey()+":"+e.getValue()+" "));

        System.out.println();

        //数组
        String[] arr1={"aaa","bbb","ccc","ddd"};
        //获取数组的stream流
        Stream<String> stream3=Arrays.stream(arr1);
        //stream流进行终结操作遍历操作
        stream3.forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.print(s+" ");
            }
        });
        //链式表达式
        System.out.println();
        Arrays.stream(arr1).forEach(s->System.out.print(s+" "));
        /*
         * Stream接口中静态方法of的细节
         * 方法的形参是一个可变参数，可以传递零散的数据，也可以传递数组
         * 但是数组必须是引用数据类型
         * 若传递的是基本数据类型数组，会将整个数组视为一个元素放入stream流中
         */
        System.out.println();
        int[] arr2={111,222,333,444};
        Stream.of(arr2).forEach(i->System.out.print(i+" ")); //[I@7cca494b


        System.out.println();

        //零散数据（必须是同种数据类型）
        Stream.of("aaa","bbb","ccc","ddd").forEach(t->System.out.print(t+" "));
    }
}
