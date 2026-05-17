package ImmutableSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test4 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        //创建Map的不可变集合，但键值对可以超过10个
    
        HashMap<String,String> map=new HashMap<>();
        map.put("a","111");
        map.put("b","222");
        map.put("c","333");
        map.put("d","444");
        map.put("e","555");
        map.put("f","666");
        map.put("g","777");
        map.put("h","888");
        map.put("i","999");
        map.put("j","000");
        map.put("k","101");
        
        //1.读取所有的键值对（Entry对象）
        Set<Map.Entry<String,String>> set=map.entrySet();
        
        //2.把set变成一个数组
        Map.Entry<String,String>[] arr=new Map.Entry[0];
        /*
         * toArray方法在底层会比较集合的长度和数组长度
         * 如果集合的长度大于数组的长度，会自动创建一个新的数组
         * 如果集合的长度小于数组的长度，会将集合中的元素拷贝到数组中
         */
        arr=set.toArray(arr); //将set转化为数组传递给arr
        
        //3.创建不可变集合
        Map<String,String> mp=Map.ofEntries(arr);

        Set<String> key=mp.keySet();
        for(String k:key){
            String value=mp.get(k);
            System.out.print(k+":"+value+" ");
        }

        //JDK10以后
        Map<String,String> mmpp=Map.copyOf(map);
        System.out.println(mmpp);
    }
}
