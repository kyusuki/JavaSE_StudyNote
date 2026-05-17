package taskTen;

import java.time.ZoneId;
import java.util.Set;

public class Test1 {
    public static void main(String[] args){
        /*
         * static Set<String> getAvailableZoneIds()    获取Java中支持的所有时区
         * static ZoneId systemDefault()               获取系统默认时区
         * static ZoneId of(String zoneId)             获取一个指定时区 
         */
        //需求1
        Set<String> zoneIds=ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);

        //需求2
        ZoneId zoneId=ZoneId.systemDefault();
        System.out.println(zoneId);

        //需求3
        ZoneId zoneId2=ZoneId.of("Europe/Monaco");
        System.out.println(zoneId2);
    }
}
