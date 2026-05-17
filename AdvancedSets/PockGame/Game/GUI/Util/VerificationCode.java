package PockGame.Game.GUI.Util;

import java.util.Random;

public class VerificationCode {
    public static String code(){
        Random r=new Random();
        char[] ch=new char[5];
        for(int i=0;i<5;i++){
            int a=r.nextInt(2);
            if(a==0){
                ch[i]=(char)(r.nextInt(26)+65); //随机大写
            }
            else{
                ch[i]=(char)(r.nextInt(26)+97); //随机小写
            }
        }
        int index=r.nextInt(5);
        ch[index]=(char)(r.nextInt(10)+48); //随机数字
        String str=new String(ch);
        return str;
    }
}
