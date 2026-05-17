package Exception;

public class Test2 {
    public static void main(String[] args){
        /*
         * public String getMessage()       返回此throwable的详细消息字符串
         * public String toString()         返回此可抛出的简短描述
         * public void printStackTrace()    把异常的错误信息输出在控制台
         */
        int[] arr={1,2,3,4,5};
        try{
            System.out.println(arr[5]);
        } catch(ArrayIndexOutOfBoundsException e){
            String message=e.getMessage();
            System.out.println(message);

            String str=e.toString();
            System.out.println(str);

            e.printStackTrace();
            /*
             * 细节：
             * 1.仅是打印信息，不会终止程序
             * 2.底层是利用System.err.println()方法打印的
             */
        }
    }
}
