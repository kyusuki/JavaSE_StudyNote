package 升级版;
import java.util.Random;
public class VerificationCode {
    public String getCode(){
        Random r=new Random();
        char[] code=new char[5];
        for(int i=0;i<5;i++){
            int a=r.nextInt(2);
            if(a==0){
                code[i]=(char)(r.nextInt(26)+65); //随机大写
            }
            else{
                code[i]=(char)(r.nextInt(26)+97); //随机小写
            }
        }   
        int index=r.nextInt(5);
        code[index]=(char)(r.nextInt(10)+48); //随机数字
        String str=new String(code);
        return str;
    }
}
