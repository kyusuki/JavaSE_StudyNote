package taskEleven;
import java.util.Scanner;
public class Test5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if(!(str.length()>=1||str.length()<=10)){
            sc.close();
            return;
        }
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!(c>='0'&&c<='9')){
                sc.close();
                return;
            }
        }
        if(str.charAt(0)=='0'){
            sc.close();
            return;
        }
        int num=Integer.parseInt(str);
        System.out.println(num);
        sc.close();
    }
}
