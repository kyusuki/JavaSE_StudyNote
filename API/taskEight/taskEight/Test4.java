package taskEight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
    public static void main(String[] args){
        String str="快和我一起学习Java吧，请联系"+
        "电话：13800000000，18500000000"+
        "或者邮箱：123@qq.com"+
        "座机：010-88888888"+
        "热线电话：400-888-8888，400-444-4444，4001111111";
        Pattern p1=Pattern.compile("1[3-9]\\d{9}");
        Pattern p2=Pattern.compile("\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}");
        Pattern p3=Pattern.compile("0\\d{2,3}-?[1-9]\\d{6,8}");
        Matcher m1=p1.matcher(str);
        Matcher m2=p2.matcher(str);
        Matcher m3=p3.matcher(str);
        while(m1.find()){
            System.out.println(m1.group());
        }
        while(m2.find()){
            System.out.println(m2.group());
        }
        while(m3.find()){
            System.out.println(m3.group());
        }
    }
}
