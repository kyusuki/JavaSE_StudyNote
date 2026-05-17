package 练习;

public class adjust2 {
    public static void main(String[] args){
        //str.toCharArray() 字符串转换为字符数组
        String A="abcde";
        String B="cdeab";
        System.out.println(f(A,B));
    }
    public static boolean f(String A,String B){
        if(A.length()!=B.length()){
            return false;
        }
        char[] c=new char[A.length()];
        for(int i=0;i<A.length();i++){
            c[i]=A.charAt(i);
        }
        int count=0;
        while(true){
            char temp=c[0];
            for(int i=0;i<A.length()-1;i++){
                c[i]=c[i+1];
            }
            c[A.length()-1]=temp;
            count++;
            String s=new String(c);
            if(s.equals(B)){
                System.out.println(count);
                return true;
            }
            if(count==A.length()){
                break;
            }
        }
        return false;
    }
}
