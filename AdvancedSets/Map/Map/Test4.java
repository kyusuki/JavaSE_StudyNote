package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Test4 {
    public static void main(String[] args){
        //第三种遍历方式，Lambda表达式遍历
        Map<String,String> map=new HashMap<>();
        map.put("张三","123");
        map.put("李四","aaa");
        map.put("王五","456bbb");

        //Lambda表达式遍历Map集合
        map.forEach(new BiConsumer<String,String>() {
            @Override
            public void accept(String key,String value){
                System.out.println(key+" "+value);
            }
        });

        System.out.println("----------------");

        //Lambda简化形式
        map.forEach((key,value)->System.out.println(key+" "+value));
    }
}
