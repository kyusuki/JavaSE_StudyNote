package taskOne;

public class Test2 {
    public static void main(String[] args){
        for(int i=100;i<=999;i++){
            int gw=i%10;
            int sw=i/10%10;
            int bw=i/100%10;
            double d=Math.pow(gw,3)+Math.pow(sw,3)+Math.pow(bw,3);
            if(d==i){
                System.out.println(i+" ");
            }
        }
        System.out.println();
        for(int i=1000;i<=9999;i++){
            int gw=i%10;
            int sw=i/10%10;
            int bw=i/100%10;
            int qw=i/1000%10;
            double d=Math.pow(gw,4)+Math.pow(sw,4)+Math.pow(bw,4)+Math.pow(qw,4);
            if(d==i){
                System.out.println(i+" ");
            }
        }
    }
}
