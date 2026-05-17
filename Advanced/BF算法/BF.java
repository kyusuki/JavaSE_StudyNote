package BF算法;
import java.util.Scanner;
public class BF {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String T=sc.next();
        int index=BF_index(S,T,0);
        if(index!=-1){
            System.out.println("位置为"+index);
        }
        else{
            System.out.println("未找到");
        }
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

 