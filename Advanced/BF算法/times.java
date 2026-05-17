package BF算法;
import java.util.Scanner;
public class times {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String T=sc.next();
        int count=0,pos=0;
        while((pos=BF_index(S,T,pos))!=-1){
            count++;
            pos++;
        }
        System.out.println(count);
        sc.close();
    }
    public static int BF_index(String S,String T,int pos){
        int i=pos,j=0;
        while(i<S.length()&&j<T.length()){
            if(S.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;
            }
        }
        if(j>=T.length()){
            return i-T.length();
        }
        else{
            return -1;
        }
    }
}
