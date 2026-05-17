package Map;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args){
        /*
         * V put(K key,V value)                       添加元素
         * V remove(Object key)                       根据键删除键值对元素
         * void clear()                               移除所有的键值对元素
         * boolean containsKey(Object key)            判断集合是否包含指定的键
         * boolean containsValue(Object value)        判断集合是否包含指定的值
         * boolean isEmpty()                          判断集合是否为空
         * int size()                                 集合的长度，也就是集合中键值对的个数
         */
        Map<String,String> map=new HashMap<>();
        //需求1
        /*
         * put方法的细节：
         * 1.如果键不存在，就直接添加键值对元素
         * 2.如果键存在，就用新值替换旧值
         * 3.返回值：
         * 键不存在：返回null
         * 键存在：返回旧值
         */
        map.put("张三","123");
        map.put("李四","aaa");
        map.put("王五","456bbb");
        System.out.println(map.put("李四","ccc")); //aaa
        System.out.println(map); //{李四=ccc, 张三=123, 王五=456bbb}
        
        System.out.println("----------------");

        //需求2
        String result=map.remove("张三");
        System.out.println(result); //123
        System.out.println(map); //{李四=ccc, 王五=456bbb}

        System.out.println("----------------");

        //需求3
        map.clear();
        System.out.println(map); //{}

        System.out.println("----------------");
        
        //需求4
        map.put("张三","123");
        map.put("李四","aaa");
        map.put("王五","456bbb");
        boolean result1=map.containsKey("王五");
        boolean result2=map.containsKey("赵六");
        System.out.println(result1); //true
        System.out.println(result2); //false

        System.out.println("----------------");

        //需求5
        boolean result3=map.containsValue("123");
        boolean result4=map.containsValue("321");
        System.out.println(result3); //true
        System.out.println(result4); //false

        System.out.println("----------------");

        //需求6与需求7
        System.out.println(map.isEmpty()); //false
        System.out.println(map.size()); //3
        map.clear();
        System.out.println(map.isEmpty()); //true
        System.out.println(map.size()); //0
    }
}
