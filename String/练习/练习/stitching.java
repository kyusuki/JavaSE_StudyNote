package 练习;

public class stitching {
    public static void main(String[] args){
        //拼接
        int[] arr={1,2,3};
        System.out.println(f(arr));
    }
    public static String f(int[] arr){
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
        return sb.toString();
    }
}
