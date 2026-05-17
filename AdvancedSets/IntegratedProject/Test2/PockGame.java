package Test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

//利用牌的序号排序
public class PockGame {
    //序号对应牌
    static HashMap<Integer,String> pockMap=new HashMap<>();
    //准备牌
    static ArrayList<Integer> pockIndex=new ArrayList<>();
    /*
     * 静态代码块
     * 特点：随着类的加载而执行的，而且只执行一次
     */
    static{
        String[] color={"♥","♠","♦","♣"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int index=1;
        //牌盒
        /*
         * 外层循环遍历数字，内层循环遍历花色
         * 保证一个数字对应四种花色
         */
        for(String n:number){
            for(String c:color){
                pockMap.put(index,c+n);
                index++;
            }
        }
        pockMap.put(index,"小王");
        index++;
        pockMap.put(index,"大王");
        //牌序号添加
        Set<Integer> keys=pockMap.keySet();
        for(Integer key:keys){
            pockIndex.add(key);
        }
    }
    public PockGame(){
        //洗牌
        Collections.shuffle(pockIndex);
        //发牌
        ArrayList<Integer> player1=new ArrayList<>();
        ArrayList<Integer> player2=new ArrayList<>();
        ArrayList<Integer> player3=new ArrayList<>();
        ArrayList<Integer> dipai=new ArrayList<>();
        for(int i=0;i<pockIndex.size();i++){
            int pock=pockIndex.get(i);
            if(i<=2){
                dipai.add(pock);
                sortPock(dipai);
            }
            else if(i%3==0){
                player1.add(pock);
                sortPock(player1);
            }
            else if(i%3==1){
                player2.add(pock);
                sortPock(player2);
            }
            else{
                player3.add(pock);
                sortPock(player3);
            }
        }
        //看牌
        lookPock("底牌", dipai);
        lookPock("danking", player1);
        lookPock("jee", player2);
        lookPock("advant", player3);
    }
    /*
     * 看牌方法
     * @param name 玩家名称
     * @param pock 玩家牌的序号，需要转换为牌面
     */
    public static void lookPock(String name,ArrayList<Integer> pock){
        System.out.print(name+": ");
        for(Integer index:pock){
            String p=pockMap.get(index);
            System.out.print(p+" ");
        }
        System.out.println();
    }
    //排序方法
    public static void sortPock(ArrayList<Integer> pock){
        Collections.sort(pock);
    }
}
