package taskTen;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test4 {
    public static void main(String[] args){
        /*
         * static DateTimeFormatter ofPattern(format)  获取格式对象
         * String format(time_object)                  按照指定方式格式化
         */
        ZonedDateTime zdt=ZonedDateTime.now();
        //获取格式化对象
        DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        //指定方式格式化
        String str1=dtf1.format(zdt);
        System.out.println(str1);
    }
}
