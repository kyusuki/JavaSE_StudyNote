package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Test4 {
    public static void main(String[] args){
        /*
         * void forEach(Consumer action)       遍历
         * long count()                        统计
         * toArray()                           收集流中的数据，放到数组中
         * collect(Collector collector)        收集流中的数据，放到集合中 
         */
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"叶莲娜","冬兵","红色守卫","美国密探","幽灵","模仿大师","哨兵");
        
        //遍历
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s){
                System.out.print(s+" ");
            }
        });
        //lambda表达式
        System.out.println();
        list.stream().forEach(s->System.out.print(s+" "));

        System.out.println();

        //统计
        long count=list.stream().count();
        System.out.println(count);

        //收集放入数组中
        //空参toArray()方法
        Object[] arr=list.stream().toArray();
        System.out.println(Arrays.toString(arr));
        //有参toArray方法
        /*
         * 细节
         * IntFunction的泛型：具体类型的数组
         * apply的形参：流中数据的个数，要与数组的长度一致
         * apply的返回值：具体类型的数组
         * 方法体：就是创建数组
         * 
         * toArray方法参数的作用：分则创建一个指定类型的数组
         * toArray方法的底层：会依次得到流里面的每一个数据，并把数据放到数组中
         * toArray方法的返回值：是一个装着流中数据的数组
         */
        String[] str=list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value){
                String[] str=new String[value];
                return str;
            }
        });
        System.out.println(Arrays.toString(str));
        //lambda表达式
        String[] str2=list.stream().toArray(value->new String[value]);
        System.out.println(Arrays.toString(str2));

        //收集放到集合中
        ArrayList<String> list2=new ArrayList<>();
        Collections.addAll(list2,"王大雷（山东泰山）","颜骏凌（上海海港）","刘殿座（成都蓉城）","朱辰杰（上海申花）","蒋光太（上海海港）","韩鹏飞（成都蓉城）","杨泽翔（上海申花）","胡荷韬（成都蓉城）","李磊（北京国安）","吴少聪（北京国安）","魏震（上海海港）","汪士钦（浙江）","王上源（河南）","徐皓阳（上海申花）","塞尔吉尼奥（北京国安）","曹永竞（北京国安）","黄政宇（山东泰山）","张玉宁（北京国安）","韦世豪（成都蓉城）","王子铭（北京国安）","王钰栋（浙江）","刘诚宇（上海申花）","杨明洋（成都蓉城）");
        List<String> lt1=list2.stream()
                .filter(s->s.contains("成都"))
                .collect(Collectors.toList());
        System.out.println(lt1);
        Set<String> lt2=list2.stream()
                .filter(s->s.contains("上海"))
                .collect(Collectors.toSet());
        System.out.println(lt2);
        Map<String,String> map=list2.stream()
                .filter(s->s.contains("北京"))
                /*
                 * toMap：
                 *    参数一表示键的生成规则
                 *    参数二表示值的生成规则
                 * 
                 * 参数一：
                 *    Function接口：
                 *       泛型一：表示流中的每一个数据的类型
                 *       泛型二：表示Map集合中键的数据类型
                 *    apply方法的形参：依次表示流中的每一个数据
                 *         方法体：获取键的代码
                 *         返回值：已经获取的键
                 * 参数二：
                 *    Function接口：
                 *       泛型一：表示流中的每一个数据的类型
                 *       泛型二：表示Map集合中值的数据类型
                 *    apply方法的形参：依次表示流中的每一个数据
                 *         方法体：获取值的代码
                 *         返回值：已经获取的值
                 */
                .collect(Collectors.toMap(new Function<String,String>() {
                    @Override
                    public String apply(String s){
                        return s.split("（")[0];
                    }
                },new Function<String,String>() {
                    @Override
                    public String apply(String s){
                        return s.split("（")[1].split("）")[0];
                    }
                }));
        System.out.println(map);
        //lambda表达式
        list2.stream().filter(s->s.contains("北京")).collect(Collectors.toMap(s->s.split("（")[0],s->s.split("（")[1].split("）")[0])).forEach((k,v)->System.out.print(k+":"+v+" "));
    }
}
