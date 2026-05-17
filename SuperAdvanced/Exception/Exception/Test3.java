package Exception;

public class Test3 {
    public static void main(String[] args){
        int[] arr={12,14,51,62,61,1,62,41,24,51};
        try{
            System.out.println(fmax(arr));
        }catch(NullPointerException e){
            System.out.println("空指针异常");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("数组下标越界异常");
        }
    }
    public static int fmax(int[] arr) throws NullPointerException,ArrayIndexOutOfBoundsException{
        if(arr==null){
            throw new NullPointerException();
        }
        if(arr.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
