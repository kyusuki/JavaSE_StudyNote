package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test2 {
    public static void main(String[] args){
        /*
         * 迭代器遍历
         * Iterator<E> iterator()                  返回迭代器对象，默认指向当前集合的0索引
         * public E next()                         返回迭代器对象当前指向的元素，并将迭代器对象指向后续元素
         * public boolean hasNext()                判断迭代器对象是否指向了集合的最后一个元素
         */

        Collection<String> coll=new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        Iterator<String> it=coll.iterator(); //获取迭代器对象
        
        /*
         * 细节：
         * 1.如果遍历到末尾在调用next方法会抛出NoSuchElementException错误
         * 2.迭代器遍历完毕，指针不会复位
         * 3.循环中之只能用一次next方法
         * 4.迭代器遍历时，不能用集合的方法进行删除的
         */
        while(it.hasNext()){ //判断是否有下一个元素
            String str=it.next(); //获取元素并移动指针
            System.out.println(str);
        }
        
        System.out.println("-----------------");
        
        Collection<String> coll2=new ArrayList<>();
        coll2.add("eee");
        coll2.add("fff");
        coll2.add("ggg");
        Iterator<String> it2=coll2.iterator();
        while(it2.hasNext()){
            String str=it2.next();
            if(str.equals("fff")){
                //coll2.remove(str);
                /*
                 * 细节：
                 * 1.迭代器遍历过程中，只能使用迭代器的remove方法进行删除操作
                 * 2.这里本应该会报错，但恰好要删除的不是最后一个，所以依然正常运行了
                 * 3.迭代器没有添加元素的方法
                 */ 
                it2.remove();
            }
        }
        System.out.println(coll2);
    }
}
