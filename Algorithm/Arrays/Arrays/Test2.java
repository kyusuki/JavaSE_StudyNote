package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {
    public static void main(String[] args){
        /*
         * public static void sort(arr,sortMethod)
         * 参数一：要排序的数组
         * 参数二：排序的规则
         * 细节：只能给引用数据类型的数组进行排序，基本类型数据要变成其对应的包装类
         */
        Integer[] arr={9,5,7,2,8,1,3,6,4};
        /*
         * 第二个参数是一个接口，所以再调用方法的时候，需要传递这个接口的实现类对象，作为排序的规则
         * 但这个实现类只要使用一次，随意直接采用匿名内部类的方式实现即可
         * 
         * 其底层原理：
         * 利用插入排序+二分查找
         * 默认把0索引的数据当作有序的序列，1索引到最后认为是无序的序列
         * 遍历无序的序列得到每个元素，假设当前遍历到的元素是o1
         * 把o1插入到有序序列中合适的位置，利用二分查找找到合适的位置
         * 将o1和插入点元素进行比较，比较的规则就是compare方法的方法体
         * 如果方法的返回值是负数，就将o1继续和前面的数据进行比较
         * 如果方法的返回值是正数，就将o1继续和后面的数据进行比较
         * 如果方法的返回值是0，也将o1和后面的数据比较
         * 直到能确定o1的最终位置
         * 
         * compare方法的形式参数
         * 参数一o1：表示在无序序列中，遍历到的每一个元素
         * 参数二o2：有序序列中的元素
         * 
         * 返回值：
         * 负数：表示当前要插入的元素是小的，放在前面
         * 正数：表示当前要插入的元素是大的，放在后面
         * 0：表示当前要插入的元素和有序序列中的元素相等，也放在后面
         * 
         * o1-o2：表示升序排序
         * o2-o1：表示降序排序
         */
        Arrays.sort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                System.out.println("o1:"+o1+" o2:"+o2);
                //按照升序排序
                return o1-o2;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
