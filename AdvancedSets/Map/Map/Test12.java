package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test12 {
    public static void main(String[] args){
        //Collections类中的方法
        ArrayList<String> list=new ArrayList<>();
        //1.添加所有元素
        Collections.addAll(list,"aaa","bbb","ccc","ddd");
        System.out.println(list); //[aaa, bbb, ccc, ddd]
        
        //2.随机打乱元素
        Collections.shuffle(list);
        System.out.println(list); //随机的，每次结果都不一样

        //3.默认规则排序
        Collections.sort(list);
        System.out.println(list); //[aaa, bbb, ccc, ddd]

        //4.指定规则排序
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                return s2.compareTo(s1);
            }
        });
        System.out.println(list); //[ddd, ccc, bbb, aaa]

        //5.以二分查找法查找元素
        Collections.sort(list);
        int index=Collections.binarySearch(list, "ccc");
        System.out.println(index); //2

        //6.拷贝元素
        ArrayList<String> list2=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list2.add("");
        }
        Collections.copy(list2,list);
        System.out.println(list2); //[aaa, bbb, ccc, ddd]

        //7.使用指定元素填充集合
        Collections.fill(list2,"eee");
        System.out.println(list2); //[eee, eee, eee, eee]

        //8.根据默认自然排序获取最大/最小元素
        System.out.println(Collections.max(list)); //ddd
        System.out.println(Collections.min(list)); //aaa

        //9.交换集合中指定位置的元素
        Collections.swap(list,1,2);
        System.out.println(list); //[aaa, ccc, bbb, ddd]
    }
}
