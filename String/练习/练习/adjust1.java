package 练习;

public class adjust1 {
    public static void main(String[] args){
        String A="abcdefg";
        String B="gfcdeba";
        System.out.println(f(A,B));
    }
    public static boolean f(String A,String B){
        char[] c=new char[A.length()];
        for(int i=0;i<A.length();i++){
            c[i]=A.charAt(i);
        }
        int count=0;
        while(count<A.length()/2){
            char temp=c[count];
            c[count]=c[A.length()-count-1];
            c[A.length()-count-1]=temp;
            String s=new String(c);
            if(s.equals(B)){
                System.out.println(count+1);
                return true;
            }
            if(count==A.length()/2-1){
                break;
            }
            count++; 
        }
        return false;
    }
}
