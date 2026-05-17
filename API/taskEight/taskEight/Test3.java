package taskEight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
    public static void main(String[] args){
        String str="Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，"+
        "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        
        //Pattern：表示正则表达式
        //Matcher：文本匹配器，按照正则表达式规则读取字符串
        
        /*
         * 获取正则表达式对象，不需要new
         * compile：编译正则表达式
         */
        Pattern p=Pattern.compile("Java\\d{0,2}");
        /*
         * 获取文本匹配器对象
         * m：文本匹配器对象
         * p：规则
         * str：要匹配的字符串
         * m要在str中找符合p规则的小串
         */
        Matcher m=p.matcher(str);
        /*
         * //find：查找符合规则的小串
         * boolean b=m.find();
         * //group：截取符合规则的小串
         * String s=m.group();
         */
        //1.for循环
         for(int i=0;i<str.length();i++){
            if(m.find()){
                System.out.println(m.group());
            }
        }
        //2.while循环
        while(m.find()){
            System.out.println(m.group());
        }
    }
}
