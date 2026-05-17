package Stream;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args){
        ArrayList<String> list1=new ArrayList<>();
        list1.add("张a");
        list1.add("张bb");
        list1.add("王c");
        list1.add("李dd");
        list1.add("张ee");

        //stream流操作
        list1.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(name->System.out.print(name+" "));
        
        System.out.println();
        
        //普通遍历判断操作
        ArrayList<String> list2=new ArrayList<>();
        for(String s:list1){
            if(s.startsWith("张")){
                list2.add(s);
            }
        }
        ArrayList<String> list3=new ArrayList<>();
        for(String s:list2){
            if(s.length()==3){
                list3.add(s);
            }
        }
        System.out.println(list2);
        System.out.println(list3);
    }
}
