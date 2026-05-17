package Test13;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Nested {
    public static void main(String[] args){
        ArrayList<String> list1=new ArrayList<>();
        Collections.addAll(list1,"路飞","索隆","山治","娜美","罗宾","乔巴","乌索普","弗兰奇","布鲁克","甚平");
        Map<String,ArrayList<String>> map1=new HashMap<>();
        map1.put("海贼王",list1);
        //获取键和值
        Set<String> keys=map1.keySet();
        for(String key:keys){
            ArrayList<String> value=map1.get(key);
            System.out.print(key+" = ");
            for(int i=0;i<value.size();i++){
                if(i<value.size()-1){
                    System.out.print(value.get(i)+", ");
                }
                else{
                    System.out.print(value.get(i));
                }
            }
        }
    }
}
