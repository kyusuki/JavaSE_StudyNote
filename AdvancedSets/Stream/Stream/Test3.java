package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args){
        /*
         * Stream<T> filter(Predicate<? super T> predicate)    过滤
         * Stream<T> limit(long maxSize)                       获取前几个元素
         * Stream<T> skip(long n)                              跳过前几个元素
         * Stream<T> distinct()                                元素去重，依赖（hashCode和equals方法）
         * static <T> Stream<T> concat(Stream a,Stream b)      合并a和b两个流为一个流
         * Stream<R> map(Function<T,R> mapper)                 转换流中的数据类型
         */
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"布加拉提","乔鲁诺・乔巴纳","阿帕基","葛德・米斯达","纳兰迦","特莉休・乌纳","福葛");

        //过滤
        //匿名内部类操作
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s){
                return s.contains("・");
            } 
        }).forEach(s->System.out.print(s+" "));
        //lambda表达式操作
        System.out.println();
        list.stream().filter(s->s.contains("・")).forEach(s->System.out.print(s+" "));

        System.out.println();

        //获取前几个元素和跳过前几个元素
        ArrayList<String> list2=new ArrayList<>();
        Collections.addAll(list2,"莉莉丝","路西法","米迦勒","加百列","别西卜","撒旦","巴尔");
        //获取（参数为获取亲几个元素，打印结果就是这几个元素）
        list2.stream().limit(3).forEach(s->System.out.print(s+" "));
        System.out.println();
        //跳过（参数为跳过前几个元素，打印结果是跳过后的元素）
        list2.stream().skip(3).forEach(s->System.out.print(s+" "));

        System.out.println();

        //元素去重
        ArrayList<String> list3=new ArrayList<>();
        Collections.addAll(list3,"东方仗助","空条承太郎","岸边露伴","广濑康一","虹村亿泰","岸边露伴","东方仗助","山岸由花子");
        list3.stream().distinct().forEach(s->System.out.print(s+" "));

        System.out.println();

        //合并流
        ArrayList<String> lt1=new ArrayList<>();
        Collections.addAll(lt1,"aaa","bbb");
        ArrayList<String> lt2=new ArrayList<>();
        Collections.addAll(lt2,"ccc","ddd");
        Stream.concat(lt1.stream(),lt2.stream()).forEach(s->System.out.print(s+" "));

        System.out.println();

        //转换流中的数据类型
        ArrayList<String> list4=new ArrayList<>();
        Collections.addAll(list4,"aaa-12","bb-34","cc-56","dd-78");
        /*
         * 细节
         * Function的第一个参数类型：流中原本的数据类型
         * Function的第二个参数类型：转换之后的数据类型
         * apply的形参s：依次表示流中的每一个数据
         * 返回值：表示转换之后的数据
         */
        /*
         * 当map方法执行完毕后，流上的数据就变成转换之后的类型
         * 所以在这里的forEach方法，s依次表示数据类型就是整数类型
         */
        list4.stream().map(new Function<String,Integer>() {
            @Override
            public Integer apply(String s){
                String[] str=s.split("-");
                return Integer.parseInt(str[1]);
            }
        }).forEach(s->System.out.print(s+" "));
        //lambda表达式操作
        System.out.println();
        list4.stream().map(s->Integer.parseInt(s.split("-")[1])).forEach(s->System.out.print(s+" "));
    }
}
