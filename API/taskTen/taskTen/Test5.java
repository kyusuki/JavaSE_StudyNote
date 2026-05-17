package taskTen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test5 {
    public static void main(String[] args){
        /*
         * 相同方法
         * static XXX now()                            获取当前时间的对象
         * static XXX of(...)                          获取指定时间的对象
         * XXX getXxx()                                获取某个字段信息
         * boolean isXxx()                             判断系列方法
         * XXX withXxx(time)                           修改系列方法
         * XXX minusXxx(time)                          减少系列方法
         * XXX plusXxx(time)                           增加系列方法
         * 区别方法
         * public LocalDate toLocalDate()              将LocalDateTime转换成LocalDate
         * public LocalTime toLocalTime()              将LocalDateTime转换成LocalTime 
         */
        //需求1
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str=dtf.format(ldt);
        System.out.println(str); //2025-11-16 16:53:47
        
        //需求2
        LocalDateTime ldt2=LocalDateTime.of(2077, 12, 31, 23, 59,59);
        String str2=dtf.format(ldt2);
        System.out.println(str2); //2077-12-31 23:59:59
        
        //需求3
        String str3=ldt2.getYear()+"年"+ldt2.getMonthValue()+"月"+ldt2.getDayOfMonth()+"日";
        System.out.println(str3); //2077年12月31日

        //需求4
        boolean result1=ldt2.isAfter(ldt);
        System.out.println(result1); //true
        boolean result2=ldt2.isBefore(ldt);
        System.out.println(result2); //false

        //需求5
        LocalDateTime ldt3=ldt2.withYear(2025);
        System.out.println(ldt3); //2025-12-31T23:59:59

        //需求6
        LocalDateTime ldt4=ldt3.minusMonths(24);
        System.out.println(ldt4); //2023-12-31T23:59:59

        //需求7
        LocalDateTime ldt5=ldt3.plusDays(365);
        System.out.println(ldt5); //2026-12-31T23:59:59

        //需求8
        LocalDate ld=ldt2.toLocalDate();
        LocalTime lt=ldt2.toLocalTime();
        System.out.println(ld); //2077-12-31
        System.out.println(lt); //23:59:59
    }
}
