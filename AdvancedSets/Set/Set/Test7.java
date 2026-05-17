package Set;

import java.util.Comparator;
import java.util.TreeSet;

public class Test7 {
    public static void main(String[] args){
        //第二种排序方式 comparator 比较器
        /*
         * o1：表示当前要添加的元素
         * o2：表示已经在红黑树中存在的元素
         * 返回值
         * 正数：表示要添加元素大于已存在元素，放右边
         * 负数：表示要添加元素小于已存在元素，放左边
         * 0：不添加
         */
        TreeSet<String> ts=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1,String o2){
                int result=o1.length()-o2.length();
                if(result==0){
                    result=o1.compareTo(o2); //默认字典序排序
                }
                return result;
            }
        });
        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");
        System.out.println(ts);
    }
}
