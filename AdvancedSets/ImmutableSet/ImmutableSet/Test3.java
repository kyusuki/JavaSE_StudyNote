package ImmutableSet;

import java.util.Map;
import java.util.Set;

public class Test3 {
    public static void main(String[] args){
        Map<String,String> map=Map.of("a","111","b","222","c","333");
        Set<Map.Entry<String,String>> entry=map.entrySet();
        for(Map.Entry<String,String> e:entry){
            String key=e.getKey();
            String value=e.getValue();
            System.out.print(key+":"+value+" ");
        }
        System.out.println();
        /*
         * 不可变集合不能进行添加，删除，修改操作，只能进行查询操作
         * map.put("d","444");
         * map.remove("a");
         * map.set("b","444"); //报错
         * 
         * 细节：
         * 当获取一个不可变的Map集合时，必须保证键的唯一性
         * Map里的of方法，参数是有上限的，最多只能传递20个参数，10个键值对
         */
        System.out.println(map);
    }
}
