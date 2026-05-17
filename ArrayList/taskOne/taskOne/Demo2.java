package taskOne;
import java.util.ArrayList;
public class Demo2 {
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<>();
        //1.添加元素
        boolean b=list.add("aaa");
        System.out.println(b); //true
        System.out.println(list); //[aaa]
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list); //[aaa,bbb,ccc,ddd]

        //2.删除元素
        boolean b1=list.remove("aaa");
        System.out.println(b1); //true
        boolean b2=list.remove("zzz");
        System.out.println(b2); //false
        System.out.println(list); //[bbb,ccc,ddd]
        
        String s=list.remove(0);
        System.out.println(s); //bbb
        System.out.println(list); //[ccc,ddd]

        //3.修改元素
        String s1=list.set(1,"eee");
        System.out.println(s1); //ddd
        System.out.println(list); //[ccc,eee]

        //4.查询元素
        String s2=list.get(0);
        System.out.println(s2); //ccc
        for(int i=0;i<list.size();i++){
            String s3=list.get(i);
            System.out.print(s3+" "); //ccc eee
        }
    }
}
