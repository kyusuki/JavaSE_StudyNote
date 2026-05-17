package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        //1.迭代器
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            String str=it.next();
            System.out.println(str);
        }
        System.out.println("------------");

        //2.增强for循环
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("------------");
      
        //3.匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.println(s);
            }
        });
        System.out.println("------------");

        //4.简化Lambda表达式
        list.forEach((s)->System.out.println(s));
        System.out.println("------------");

        //5.普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("------------");

        //6.列表迭代器
        ListIterator<String> lit=list.listIterator();
        while(lit.hasNext()){
            String str=lit.next();
            //特殊：可以在遍历中添加元素
            if(str.equals("bbb")){
                lit.add("eee");
            }
            System.out.println(str); //不会输出eee，因为在遍历bbb之后next会指向新添加元素的下一元素
        }
        System.out.println(list); //[aaa, eee, bbb, ccc]
    }
}
