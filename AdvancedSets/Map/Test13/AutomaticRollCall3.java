package Test13;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class AutomaticRollCall3 {
    public static void main(String[] args){
        //用于存放原始数据
        ArrayList<String> list1=new ArrayList<>();
        Collections.addAll(list1,"宙斯","赫拉","雅典娜","阿佛洛狄忒","赫拉克勒斯","珀尔修斯","忒修斯","阿喀琉斯","美杜莎","刻耳柏洛斯","斯芬克斯","喀迈拉");
        Collections.shuffle(list1);
        //存放每次被抽过的数据
        ArrayList<String> list2=new ArrayList<>();
        //外层循环表示轮数，内层循环表示抽取的过程
        for(int i=0;i<4;i++){
            System.out.println("---------第"+(i+1)+"轮---------");
            int count=list1.size();
            Random r=new Random();
            Scanner sc=new Scanner(System.in);
            System.out.println("1.抽取 2.结束");
            for(int j=0;j<count;j++){
                int choice=sc.nextInt();
                if(choice==1){
                    int index=r.nextInt(list1.size());
                    String name=list1.remove(index);
                    list2.add(name);
                    System.out.println(name);
                }
                else if(choice==2){
                    System.exit(0);
                }
            }
            list1.addAll(list2);
            list2.clear();
            sc.close();
        }
    }
}
