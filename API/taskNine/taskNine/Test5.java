package taskNine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test5 {
    public static void main(String[] args){
        Date d1=new Date();
        Date d2=new Date();
        Date d3=new Date();
        Date d4=new Date();
        String str1="2023年11月11日 0:01:00";
        String str2="2023年11月11日 0:11:0";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        try{
            d1=sdf.parse(str1);
            d2=sdf.parse(str2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String str3="2023年11月11日 0:0:0";
        String str4="2023年11月11日 0:10:0";
        try{
            d3=sdf.parse(str3);
            d4=sdf.parse(str4);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        long time1=d1.getTime();
        long time2=d2.getTime();
        long time3=d3.getTime();
        long time4=d4.getTime();
        if(time1>time3&&time1<time4){
            System.out.println("小贾中奖");
        }
        else if(time2>time3&&time2<time4){
            System.out.println("小皮中奖");
        }
    }
}
