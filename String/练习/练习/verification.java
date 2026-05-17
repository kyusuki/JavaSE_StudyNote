package 练习;
import java.util.Random;
public class verification {
    public static void main(String[] args){
        Random r=new Random();
        char[] arr=new char[5];
        for(int i=0;i<4;i++){
            int a=r.nextInt(2);
            if(a==0){
                arr[i]=(char)(r.nextInt(26)+65);
            }
            else{
                arr[i]=(char)(r.nextInt(26)+97);
            }
        }
        arr[4]=(char)(r.nextInt(10)+48);
        String s=new String(arr);
        System.out.println("随机验证码为："+f(s));
    }
    public static String f(String A){
        Random r=new Random();
        char[] c=A.toCharArray();
        for(int i=0;i<A.length();i++){
            int index=r.nextInt(A.length());
            char temp=c[i];
            c[i]=c[index];
            c[index]=temp;
        }
        return new String(c);
    }
}
