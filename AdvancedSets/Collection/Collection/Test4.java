package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class Test4 {
    public static void main(String[] args){
        /*
         * Lambda表达式遍历
         * default void forEach(Consumer<? super T> action):
         */
        Collection<String> coll=new ArrayList<>();
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        //匿名内部类形式
        /*
         * 底层原理：
         * forEach方法会遍历得到每一个元素
         * 把得到的元素传递给accept方法
         * s代表集合中每一个数据
         */
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.println(s);
            }
        });
        
        //Lambda表达式形式
        coll.forEach(s->System.out.println(s));
    }
}
