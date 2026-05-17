package taskNine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
    public static void main(String[] args){
        String str="2000-11-11";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        try{
            d=sdf1.parse(str);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日");
        String str2=sdf2.format(d);
        System.out.println(str2);
    }
}
