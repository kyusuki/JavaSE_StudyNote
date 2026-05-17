package Sort;

public class Test1 {
    public static void main(String[] args){
        System.out.println(recursion(5));
    }
    public static int recursion(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return n*recursion(n-1);
    }
}
