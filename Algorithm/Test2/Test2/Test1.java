package Test2;

public class Test1 {
    public static void main(String[] args){
        System.out.println(f(10,1));
    }
    public static int f(int day,int num){
        for(int i=day;i>1;i--){
            num=(num+1)*2;
        }
        return num;
    }
}
