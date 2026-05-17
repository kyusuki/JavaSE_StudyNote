package Generic.Test3;

import java.util.ArrayList;

public class ListUtil {
    private ListUtil(){}
    public static <E> void addAll(ArrayList<E> list,E e1,E e2,E e3){
        list.add(e1);
        list.add(e2);
        list.add(e3);
    }
}
