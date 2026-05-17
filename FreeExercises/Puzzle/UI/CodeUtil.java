package UI;
import java.util.Random;
public class CodeUtil {
    public String getVerification(){
        Random r=new Random();
        char[] code=new char[5];
        for(int i=0;i<5;i++){
            int a=r.nextInt(2);
            if(a==0){
                code[i]=(char)(r.nextInt(26)+65);
            }
            else{
                code[i]=(char)(r.nextInt(26)+97);
            }
        }
        int index=r.nextInt(5);
        code[index]=(char)(r.nextInt(10)+48);
        String verCode=new String(code);
        return verCode;
    }
}
