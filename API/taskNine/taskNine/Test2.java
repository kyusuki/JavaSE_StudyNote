package taskNine;

import java.util.Date;
import java.util.Random;

public class Test2 {
    public static void main(String[] args){
        //需求1：打印时间原点后一年的时间
        Date d1=new Date(0L);
        long time=d1.getTime();
        time=time+1000L*60*60*24*365;
        d1.setTime(time);
        System.out.println(d1);
        //需求2：定义两个Date对象，比较时间大小
        Random r=new Random();
        Date d2=new Date(Math.abs(r.nextInt()));
        Date d3=new Date(Math.abs(r.nextInt()));
        long time2=d2.getTime();
        long time3=d3.getTime();
        if(time2>time3){
            d2.setTime(time2);
            System.out.println(d2);
        }
        else if(time2<time3){
            d3.setTime(time3);
            System.out.println(d3);
        }
        else{
            d2.setTime(time3);
            System.out.println(d2);
        }
    }
}
