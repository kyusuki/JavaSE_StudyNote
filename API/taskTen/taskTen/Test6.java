package taskTen;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Test6 {
    public static void main(String[] args){
        //Period
        LocalDate ld1=LocalDate.now();
        LocalDate ld2=LocalDate.of(2005,2,28);
        Period period=Period.between(ld2, ld1); //第二个参数减第一个参数
        System.out.println("我"+period.getYears()+"岁"+period.getMonths()+"月"+period.getDays()+"天");
        System.out.println("总共"+period.toTotalMonths()+"月");

        //Duration
        LocalTime lt1=LocalTime.now();
        LocalTime lt2=LocalTime.of(23,59,59);
        Duration duration=Duration.between(lt1, lt2); //第二个参数减第一个参数
        System.out.println("距离零点还剩"+duration.toHours()+"小时"+duration.toMinutesPart()+"分"+duration.toSecondsPart()+"秒");

        //ChronoUnit
        LocalDateTime ldt1=LocalDateTime.now();
        LocalDateTime ldt2=LocalDateTime.of(2076,12,31,23,59,59);
        System.out.println("相差年数："+ChronoUnit.YEARS.between(ldt1, ldt2));
        System.out.println("相差月数："+ChronoUnit.MONTHS.between(ldt1, ldt2));
        System.out.println("相差周数："+ChronoUnit.WEEKS.between(ldt1, ldt2));
        System.out.println("相差天数："+ChronoUnit.DAYS.between(ldt1, ldt2));
        System.out.println("相差时数："+ChronoUnit.HOURS.between(ldt1, ldt2));
        System.out.println("相差分数："+ChronoUnit.MINUTES.between(ldt1, ldt2));
        System.out.println("相差秒数："+ChronoUnit.SECONDS.between(ldt1, ldt2));
    }
}
