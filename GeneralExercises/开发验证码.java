import java.util.Random;
public class 开发验证码 {
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
        for(int i=0;i<5;i++){
            System.out.print(arr[i]);
        }
    }
}
