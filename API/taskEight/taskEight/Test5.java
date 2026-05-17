package taskEight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {
    public static void main(String[] args){
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，"+
        "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        
        //需求1：爬取版本号为8、11、17的Java，但只显示Java
        String regex1="Java(?=8|11|17)";
        Pattern p1=Pattern.compile(regex1);
        Matcher m1=p1.matcher(str);
        while(m1.find()){
            System.out.println(m1.group());
        }
        System.out.println("-----------------");
        //需求2：爬取版本号为8、11、17的Java，显示版本号
        String regex2="Java(8|11|17)";
        Pattern p2=Pattern.compile(regex2);
        Matcher m2=p2.matcher(str);
        while(m2.find()){
            System.out.println(m2.group());
        }
        System.out.println("-----------------");
        //需求3：爬取除了版本号为8、11、17的Java
        String regex3="Java(?!8|11|17)";
        Pattern p3=Pattern.compile(regex3);
        Matcher m3=p3.matcher(str);
        while(m3.find()){
            System.out.println(m3.group());
        }
    }
}
