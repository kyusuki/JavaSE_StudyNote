import java.util.Random;
public class 打乱数据 {
    public static void main(String[] args){
        int []arr={1,2,3,4,5};
        Random r=new Random();
        for(int i=0;i<5;i++){
            int random=r.nextInt(5);
            int temp=arr[i];
            arr[i]=arr[random];
            arr[random]=temp;
        }
        for(int i=0;i<5;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
