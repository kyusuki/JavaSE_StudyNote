package ImmutableSet;

import java.util.List;

public class Test1 {
    public static void main(String[] args){
        List<String> list=List.of("张三","李四","王五","赵六");
        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println();
        /*
         * 不可变集合不能进行添加，删除，修改操作
         * list.add("钱七"); 
         * list.remove(2);
         * list.set(1,"aaa");
         */
        System.out.println(list);
    }
}
