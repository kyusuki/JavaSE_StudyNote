package Map;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test2 {
    public static void main(String[] args){
        //第一种遍历方法，通过键找值
        Map<String,String> map=new HashMap<>();
        map.put("张三","123");
        map.put("李四","aaa");
        map.put("王五","456bbb");
        
        //1.获取所有的键，将这些键放在一个单列集合中
        Set<String> keys=map.keySet();
        //2.遍历单列集合，得到每一个键（增强for遍历）
        for(String key:keys){
            //3.利用Map集合的get方法，根据键找值
            String value=map.get(key);
            System.out.println(key+" "+value);
        }

        System.out.println("----------------");

        //迭代器遍历
        Iterator<String> it=keys.iterator();
        while(it.hasNext()){
            String key=it.next();
            String value=map.get(key);
            System.out.println(key+" "+value);
        }

        System.out.println("----------------");

        //Lambda表达式遍历
        keys.forEach((key)->{
            String value=map.get(key);
            System.out.println(key+" "+value);
        });
    }
}
