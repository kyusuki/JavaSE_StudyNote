package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Test1 {
    public static void main(String[] args){
        /*
         * public boolean add(E e)                  把给定的对象添加到当前集合中
         * public void clear()                      清空集合中所有的元素
         * public boolean remove(E e)               把给定的对象在当前集合中删除
         * public boolean contains(Object obj)      判断当前集合中是否包含给定的对象
         * public boolean isEmpty()                 判断当前集合是否为空
         * public int size()                        返回集合中元素的个数/集合长度 
         */

        /*
         * 注意：
         * Collection是一个接口，不能直接创建对象
         * 可以通过多态的方式，创建其实现类的对象
         */
        Collection<String> coll=new ArrayList<>();
        
        //需求1：
        /*
         * 细节
         * 如果往List系列集合中添加元素，方法永远返回true
         * 但如果往Set系列集合中添加元素，若集合中不存在该元素，则返回true，反之返回false
         */
        coll.add("abc");
        coll.add("def");
        System.out.println(coll); //[abc, def]
        System.out.println("-----------------");
        
        //需求2：
        coll.clear();
        System.out.println(coll); //[]
        System.out.println("-----------------");
        
        //需求3：
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll); //[aaa, bbb, ccc]
        coll.remove("bbb"); 
        System.out.println(coll); //[aaa, ccc]
        System.out.println("-----------------");

        //需求4
        /*
         * 细节：底层依赖equals方法判断是否存在
         * 如果集合中存放的是自定义元素，使用contains方法时必须要再JavaBean类中重写equals方法
         */
        System.out.println(coll.contains("aaa")); //true
        System.out.println(coll.contains("bbb")); //false
        System.out.println("-----------------");

        //需求5
        Collection<String> coll2=new ArrayList<>();
        System.out.println(coll.isEmpty()); //false
        System.out.println(coll2.isEmpty()); //true
        System.out.println("-----------------");

        //需求6
        System.out.println(coll.size()); //2
        System.out.println(coll2.size()); //0
    }
}
