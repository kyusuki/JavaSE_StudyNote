package taskNine;

import java.util.Calendar;
import java.util.Date;

public class Test6 {
    public static void main(String[] args){
        /*
         * public static Calendar getInstance()     获取当前时间的日历对象
         *
         * public final Date getTime()              获取日期对象
         * public final setTime(Date date)          给日历设置日期对象
         * public long getTimeInMillis()            获取时间毫秒值
         * public void setTimeInMillis(long millis) 给日历设置时间毫秒值 
         * public int get(int field)                获取日历中的某个字段信息
         * public void set(int field,int value)     修改日历的某个字段信息
         * public void add(int field,int amount)    给某个字段增加/减少指定的值
         */
        Calendar c=Calendar.getInstance(); //获取对象，而不是创建对象
        //1.获取日期对象
        Date d=c.getTime();
        System.out.println(d);

        //2.修改日历代表的时间
        Date d1=new Date(0L);
        c.setTime(d1);
        System.out.println(c);
        
        /*
         * 3.获取字段信息
         * 索引0：纪元 1：年 2：月 3：一年中的第几周 4：一个月中的第几周 5：一个月中的个第几天...
         */
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH)+1; //规定：月份是从0开始的
        int day=c.get(Calendar.DAY_OF_MONTH);
        int week=c.get(Calendar.DAY_OF_WEEK);
        System.out.println(year+"-"+month+"-"+day+" "+getWeek(week));

        //4.修改字段信息
        c.set(Calendar.YEAR,2025);
        c.set(Calendar.MONTH,10);
        c.set(Calendar.DAY_OF_MONTH,15);
        Date d2=c.getTime();
        System.out.println(d2);

        //5.给某个字段增减/减少指定的值
        c.add(Calendar.YEAR,10);
        c.add(Calendar.MONTH,-5);
        Date d3=c.getTime();
        System.out.println(d3);
    }
    public static String getWeek(int week){
        String[] weeks={"","星期日","星期一","星期二","星期三","星期四","星期五","星期六" }; //规定：星期日时一周的第一天
        return weeks[week];
    }
}
