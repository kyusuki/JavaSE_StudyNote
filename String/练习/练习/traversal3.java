package 练习;  //定义方法，拼接字符串

public class traversal3 {
    public static void main(String[] args){
        int[] arr={1,1,4,5,1,4};
        String str=toString(arr);
        System.out.println(str);
    }
    public static String toString(int[] arr){
        if(arr==null){
            return "null";
        }
        else if(arr.length==0){
            return "[]";
        }
        else{
            String result="[";
            for(int i=0;i<arr.length;i++){
                if(i<arr.length-1){
                    result=result+arr[i]+",";
                }
                else{
                    result=result+arr[i]+"]";
                    break;
                }
            }
            return result;
        }
    }
}
