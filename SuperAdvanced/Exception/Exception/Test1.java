package Exception;

public class Test1 {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        try{
            //可能出现异常的代码
            System.out.println(arr[5]);
            /*
             * 此处出现异常，程序就会在这里创建一个ArrayIndexOutOfBoundsException对象
             * new ArrayIndexOutOfBoundsException();
             * 将这个对象与catch中的e进行匹配，看括号中的变量是否可以接收这个对象
             * 如果能被接受，就表示该异常被捕获，执行catch里面的代码
             * 当catch里面的所有代码执行完毕，继续执行try...catch后的代码
             */
        }catch(ArrayIndexOutOfBoundsException e){
            //出现异常后的处理代码
            System.out.println("数组下标越界异常");
        }
        System.out.println("这一步已运行");
    }
}
