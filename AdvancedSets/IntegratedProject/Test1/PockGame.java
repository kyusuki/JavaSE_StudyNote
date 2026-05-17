package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//利用牌的价值排序
public class PockGame {
    //价值键值对
    static HashMap<String,Integer> hm=new HashMap<>();
    //牌堆
    static ArrayList<String> list=new ArrayList<>();
    static{
        String[] color={"♥","♠","♦","♣"};
        String[] number={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        for(String c:color){
            for(String n:number){
                list.add(c+n);
            }
        }
        list.add("小王");
        list.add("大王");
        //指定牌的价值
        hm.put("J",11);
        hm.put("Q",12);
        hm.put("K",13);
        hm.put("A",14);
        hm.put("2",15);
        hm.put("小王",50);
        hm.put("大王",100);
    }
    public PockGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> dipai=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            String pock=list.get(i);
            if(i<=2){
                dipai.add(pock);
            }
            else if(i%3==0){
                player1.add(pock);
            }
            else if(i%3==1){
                player2.add(pock);
            }
            else if(i%3==2){
                player3.add(pock);
            }
        }
        sortPock(dipai);
        sortPock(player1);
        sortPock(player2);
        sortPock(player3);
        //看牌
        lookPock("底牌",dipai);
        lookPock("danking",player1);
        lookPock("jee",player2);
        lookPock("advant",player3);
    }
    //看牌方法
    public static void lookPock(String name,ArrayList<String> pock){
        System.out.print(name+": ");
        for(String p:pock){
            System.out.print(p+" ");
        }
        System.out.println();
    }
    //排序
    public static void sortPock(ArrayList<String> pock){
        Collections.sort(pock,new Comparator<String>() {
           @Override
            public int compare(String o1,String o2){
                //单独考虑大小王的情况
                if((o1.equals("大王")||o1.equals("小王"))&&!(o2.equals("大王")||o2.equals("小王"))){
                    return 1;
                }
                else if(!(o1.equals("大王")||o1.equals("小王"))&&(o2.equals("大王")||o2.equals("小王"))){
                    return -1;
                }
                else if(o1.equals("大王")&&o2.equals("小王")||o2.equals("大王")&&o1.equals("小王")){
                    return hm.get(o1)-hm.get(o2);
                }
                /*
                 * 先比较牌的价值
                 * 如果价值相同则比较花色
                 */
                else{
                    //计算o1的花色和价值
                    String color1=o1.substring(0,1);
                    int value1=getValue(o1);
                    //计算o2的花色和价值
                    String color2=o2.substring(0,1);
                    int value2=getValue(o2);
                    int result=value1-value2;
                    if(result==0){
                        return color1.compareTo(color2);
                    }
                    return result;
                }    
            }
        });
    }
    //获取牌的价值
    public static int getValue(String pock){
        String key=pock.substring(1);
        /*
         * 将获取的牌的价值与HashMap中指定的键进行比较
         * 如果存在则直接返回键对应的值
         * 如果不存在则将此2价值转化为整数返回
         */
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        else{
            return Integer.parseInt(key);
        }
    }
}
