package taskOne.Demo2;

public class ArrayUtil {
    private ArrayUtil(){} //私有化构造方法
    public static String printArr(int[] arr){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<arr.length;i++){
            if(i<arr.length-1){
                sb.append(arr[i]+",");
            }
            else{
                sb.append(arr[i]+"]");
            }
        }
        String s=sb.toString();
        return s;
    }
    public static double getAvg(int[] arr){
        double avg=0.0,sum=0.0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        avg=sum/arr.length;
        return avg;
    }
}
