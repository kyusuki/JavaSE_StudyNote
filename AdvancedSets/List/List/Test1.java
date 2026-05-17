package List;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args){
        /*
         * void add(int index,E element)             在此集合中的指定位置插入指定元素
         * E remove(int index)                       删除指定索引处的元素，返回被删除的元素
         * E set(int index,E element)                修改指定索引处的元素，返回被修改的元素
         * E get(int index)                          返回指定索引处的元素
         */
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list); //[aaa, bbb, ccc]
        System.out.println("------------");

        //需求1：指定索引处插入元素
        list.add(1,"ddd");
        System.out.println(list); //[aaa, ddd, bbb, ccc]
        System.out.println("------------");

        //需求2：删除指定位置元素
        /*
         * 细节
         * 当方法出现重载时，优先调用实参和形参类型一致的方法
         */
        list.remove(2);
        System.out.println(list); //[aaa, ddd, ccc]
        System.out.println("------------");

        //需求3：修改指定位置的元素
        list.set(2,"ggg");
        System.out.println(list); //[aaa, ddd, ggg]
        System.out.println("------------");
 
        //需求4：返回指定位置元素
        String str=list.get(0);
        System.out.println(str); //aaa
    }
}
