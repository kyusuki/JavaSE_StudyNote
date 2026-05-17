package Stream.Test5.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ts {
    public static void main(String[] args){
        ArrayList<Actor> listMan=new ArrayList<>();
        ArrayList<Actor> listWoman=new ArrayList<>();
        Collections.addAll(listMan,new Actor("赵aa,12"),new Actor("钱b,18"),new Actor("孙c,19"),new Actor("李dd,20"),new Actor("周ee,21"),new Actor("吴ff,22"));
        Collections.addAll(listWoman,new Actor("王gg,12"),new Actor("冯h,13"),new Actor("陈ii,14"),new Actor("杨j,15"),new Actor("卫kk,16"),new Actor("杨mm,17"));
        List<Actor> ltm=listMan.stream().filter(a->a.getNameAge().split(",")[0].length()==3).limit(2).collect(Collectors.toList());
        List<Actor> ltw=listWoman.stream().filter(a->a.getNameAge().split(",")[0].startsWith("杨")).skip(1).limit(1).collect(Collectors.toList());
        System.out.println(ltm);
        System.out.println(ltw);
        List<Actor> lta=Stream.concat(ltm.stream(),ltw.stream()).collect(Collectors.toList());
        System.out.println(lta);
    }
}
