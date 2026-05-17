import java.util.Random;
public class 抢红包 {
    public static void main(String[] args){
        int[] arr={2,588,888,1000,10000};
        Random r=new Random();
        int[] result=f(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println("第"+(i+1)+"个人抢到"+result[i]+"元红包");
        }
    }
    public static int[] f(int[] arr){
        int[] result=new int[arr.length];
        boolean[] flag=new boolean[arr.length];
        Random r=new Random();
        for(int i=0;i<arr.length;i++){
            int index;
            do{
                index=r.nextInt(arr.length);
            }while(flag[index]);
            result[i]=arr[index];
            flag[index]=true;
        }
        return result;
    }
}
