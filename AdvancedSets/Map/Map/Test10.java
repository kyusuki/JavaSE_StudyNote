package Map;

import java.util.ArrayList;
import java.util.TreeMap;

public class Test10 {
    public static void main(String[] args){
        String str="aababcabcdabcde";
        ArrayList<String> list=new ArrayList<>();
        TreeMap<String,Integer> tm=new TreeMap<>();
        for(int i=0;i<str.length();i++){
            String key=str.substring(i,i+1);
            list.add(key);
        }
        int count=0;
        for(String key:list){
            if(tm.containsKey(key)){
                count=tm.get(key);
                count++;
                tm.put(key,count);
            }
            else{
                tm.put(key,1);
            }
        }
        for(String key:tm.keySet()){
            int value=tm.get(key);
            System.out.print(key+" ("+value+") ");
        }
    }
}
