package taskOne;
import java.util.ArrayList;
public class Demo1{
    public static void main(String[] args){
        //泛型：限定集合中存储数据类型 <>
        ArrayList<String> list=new ArrayList<>();
        System.out.println(list); //输出为 [] 并非地址值
    }
}