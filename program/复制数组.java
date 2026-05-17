public class 复制数组 {
    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7,8,9,10};
        f(a,2,5);
    }
    public static void f(int[] a,int from,int to){
        int[] b=new int[to-from+1];
        for(int i=from;i<=to;i++){
            b[i-from]=a[i];
        }
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
