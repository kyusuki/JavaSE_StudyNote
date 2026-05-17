package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test3 {
    public static void main(String[] args){
        //第二种遍历方法，通过键值对获取
        Map<String,String> map=new HashMap<>();
        map.put("张三","123");
        map.put("李四","aaa");
        map.put("王五","456bbb");
        
        //1.通过一个方法获取所有键值对对象，返回一个Set集合
        Set<Entry<String,String>> entries=map.entrySet();
        //2.遍历Set集合，获取每一个键值对对象（增强for遍历）
        for(Entry<String,String> entry:entries){
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" "+value);
        }

        System.out.println("----------------");

        //迭代器遍历
        Iterator<Entry<String,String>> it=entries.iterator();
        while(it.hasNext()){
            Entry<String,String> entry=it.next();
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" "+value);
        }

        System.out.println("----------------");

        //Lambda表达式遍历
        entries.forEach((entry)->{
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println(key+" "+value);
        });
    }
}
