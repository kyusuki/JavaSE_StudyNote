package Map;

import java.util.LinkedHashMap;

public class Test7 {
    public static void main(String[] args){
        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();
        lhm.put("bbb",111);
        lhm.put("ccc",222);
        lhm.put("aaa",111);
        lhm.put("ccc",333);
        System.out.println(lhm);
    }
}
