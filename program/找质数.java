public class 找质数 {
    public static void main(String[] args){
        int count=0;
        for(int i=1;i<=100;i++){
            if(f(i)){
                count++;
                System.out.print(i+" ");
            }
        }
        System.out.println();
        System.out.println("100以内质数个数为："+count);
    }
    public static boolean f(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
