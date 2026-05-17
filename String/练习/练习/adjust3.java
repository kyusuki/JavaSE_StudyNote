package 练习;

public class adjust3 {
    public static void main(String[] args){
        String A="abcde";
        String B="cdeab";
        System.out.println(f(A,B));
    }
    public static boolean f(String A,String B){
        if(A.length()!=B.length()){
            return false;
        }
        for(int i=0;i<A.length();i++){
            A=rotate(A);
            if(A.equals(B)){
                return true;
            }
        }
        return false;
    }
    public static String rotate(String A){
        char first=A.charAt(0);
        String end=A.substring(1);
        String s=end+first;
        return s;
    }
}
