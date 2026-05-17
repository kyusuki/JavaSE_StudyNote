package taskEight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test6 {
    public static void main(String[] args){
        String str="abbbbbbbbbbbaaaaaaaaaaaaaaaaaa";
        /*
         * 非贪婪爬取：+?  *?
         * 在爬取数据时尽可能少获取数据
         * 
         * 贪婪爬取：+  *
         * 在爬取数据时尽可能多获取数据
         */
        String regex1="ab+";
        Pattern p1=Pattern.compile(regex1);
        Matcher m1=p1.matcher(str);
        while(m1.find()){
            System.out.println(m1.group());
        }
        System.out.println("-----------------");
        String regex2="ab+?";
        Pattern p2=Pattern.compile(regex2);
        Matcher m2=p2.matcher(str);
        while(m2.find()){
            System.out.println(m2.group());
        }
    }
}
