package taskTen;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test2 {
    public static void main(String[] args){
        /*
         * static Instant now()                        获取当前时间的Instant对象（标准时间）
         * static Instant ofXxx(long epochMilli)       根据（秒/毫秒/纳秒）获取Instant对象
         * ZonedDateTime atZone(ZoneId zone)           指定时区
         * boolean isXxx(Instant otherInstant)         判断系列方法
         * Instant minusXxx(long millisToSubtract)     减少时间系列方法
         * Instant plusXxx(long millisToSubtract)      增加时间系列方法
         */
        //需求1
        Instant now=Instant.now();
        System.out.println(now); //2025-11-16T07:54:24.837324700Z

        //需求2
        Instant instant1=Instant.ofEpochMilli(0L);
        System.out.println(instant1); //1970-01-01T00:00:00Z
        Instant instant2=Instant.ofEpochSecond(1L);
        System.out.println(instant2); //1970-01-01T00:00:01Z
        Instant instant3=Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant3); //1970-01-01T00:00:02Z

        //需求3
        ZonedDateTime zdt=Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt); //2025-11-16T15:54:24.845326700+08:00[Asia/Shanghai]

        //需求4
        boolean result1=instant1.isBefore(instant2);
        System.out.println(result1); //true
        boolean result2=instant2.isAfter(instant3);
        System.out.println(result2); //false

        //需求5
        Instant instant4=instant3.minusSeconds(1L);
        System.out.println(instant4); //1970-01-01T00:00:01Z
        Instant instant5=instant3.plusMillis(1000L);
        System.out.println(instant5); //1970-01-01T00:00:03Z
    }
}
