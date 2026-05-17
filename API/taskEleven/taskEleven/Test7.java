package taskEleven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test7 {
    public static void main(String[] args) throws ParseException{
        //JDK7以前
        String birth="2005-02-28";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=sdf.parse(birth);
        long birthTime=date.getTime();
        long currentTime=System.currentTimeMillis();
        long day=currentTime-birthTime;
        System.out.println(day/1000/60/60/24+"天");

        //JDK8以后
        LocalDateTime birthDay=LocalDateTime.of(2005,2,28,0,0,0);
        LocalDateTime now=LocalDateTime.now();
        long passDay=ChronoUnit.DAYS.between(birthDay, now);
        System.out.println(passDay+"天");
    }
}
