package Map;

public class Test11 {
    public static void main(String[] args){
        /*
         * 可变参数
         * 方法形参的个数是可以变化的
         * 格式：属性类型...变量名
         */
        System.out.println(getSum(1,2,3,4,5,6,7,8,9,10)); //55
    }
    /*
     * 底层：
     * 可变参数的底层就是一个数组
     * 调用方法时，Java会自动创建一个数组
     */
    public static int getSum(int...arr){
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        return sum;
    }
}
