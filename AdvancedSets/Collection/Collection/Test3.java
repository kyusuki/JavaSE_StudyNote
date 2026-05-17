package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class Test3 {
    public static void main(String[] args){
        /*
         * 增强for循环
         * for(元素数据类型 变量名:数组或集合){}
         */
        Collection<String> coll=new ArrayList<>();
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵四");
        for(String s:coll){
            System.out.println(s);
        }
    }
}
