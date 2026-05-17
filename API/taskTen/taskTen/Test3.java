package taskTen;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test3 {
    public static void main(String[] args){
        /*
         * static ZonedDateTime now()                  获取当前时间的ZonedDateTime对象
         * static ZonedDateTime ofXxx()                获取指定时间的ZonedDateTime对象
         * ZonedDateTime withXxx(time)                 修改时间系列方法
         * ZonedDateTime minusXxx(time)                减少时间系列方法
         * ZonedDateTime plusXxx(time)                 增加时间系列方法 
         */
        //需求1
        ZonedDateTime zdt1=ZonedDateTime.now();
        System.out.println(zdt1); //2025-11-16T16:07:31.149026300+08:00[Asia/Shanghai]

        //需求2
        ZonedDateTime zdt2=ZonedDateTime.of(2025, 11, 16, 15, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt2); //2025-11-16T15:00+08:00[Asia/Shanghai]

        //需求3
        ZonedDateTime zdt3=zdt1.withYear(2023);
        System.out.println(zdt3); //2023-11-16T16:07:31.149026300+08:00[Asia/Shanghai]

        //需求4
        ZonedDateTime zdt4=zdt1.minusDays(365);
        System.out.println(zdt4); //2024-11-16T16:07:31.149026300+08:00[Asia/Shanghai]

        //需求5
        ZonedDateTime zdt5=zdt1.plusYears(52);
        System.out.println(zdt5); //2077-11-16T16:07:31.149026300+08:00[Asia/Shanghai]
    }
}
