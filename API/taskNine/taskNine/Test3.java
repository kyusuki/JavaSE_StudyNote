package taskNine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
    public static void main(String[] args){
        /*
         * public SimpleDateFormat()                构造一个SimpleDateFormat空参对象，使用默认格式
         * public SimpleDateFormat(String pattern)  构造一个SimpleDateFormat有参对象，使用指定格式
         * 
         * public final String format(Date date)    格式化（日期对象->字符串）
         * public Date parse(String source)         解析（字符串->日期对象）
         */
        //1.默认格式
        SimpleDateFormat sdf1=new SimpleDateFormat();
        Date d=new Date();
        String str1=sdf1.format(d);
        System.out.println(str1);
        
        //2.指定格式
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        String str2=sdf2.format(d);
        System.out.println(str2);
        
        //3.解析
        //细节：创建对象的格式要与字符串的格式一致
        String str3="2025年05月20日 15:30:00 星期四";
        try{
            Date d3=sdf2.parse(str3);
            System.out.println(d3);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
