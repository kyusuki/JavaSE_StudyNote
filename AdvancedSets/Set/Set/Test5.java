package Set;

import java.util.Iterator;
import java.util.TreeSet;

public class Test5 {
    public static void main(String[] args){
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(53);
        ts.add(25);
        ts.add(78);
        ts.add(6);
        ts.add(44);
        System.out.println(ts); //[6, 25, 44, 53, 78]

        //Iterator遍历
        Iterator<Integer> it=ts.iterator();
        while(it.hasNext()){
            Integer i=it.next();
            System.out.print(i+" ");
        }
        System.out.println();

        //增强for遍历
        for(Integer i:ts){
            System.out.print(i+" ");
        }
        System.out.println();

        //Lambda表达式遍历
        ts.forEach((i)->System.out.print(i+" "));
    }
}
