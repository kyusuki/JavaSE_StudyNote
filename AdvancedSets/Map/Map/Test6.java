package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test6 {
    public static void main(String[] args){
        String[] places={"北京","上海","深圳","重庆"};
        ArrayList<String> list=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<50;i++){
            int index=r.nextInt(places.length);
            list.add(places[index]);
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(String place:list){
            if(map.containsKey(place)){
                int count=map.get(place);
                count++;
                map.put(place,count);
            }
            else{
                map.put(place,1);
            }
        }
        int max=0;
        for(String key:map.keySet()){
            int count=map.get(key);
            if(count>=max){
                max=count;
            }
        }
        System.out.println(map);
        System.out.print("票数最多的是：");
        for(String key:map.keySet()){
            if(map.get(key)==max){
                System.out.print(key+" ");
            }
        }
    }
}
