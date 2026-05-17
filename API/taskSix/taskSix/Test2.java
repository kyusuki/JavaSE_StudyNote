package taskSix;

import java.math.BigInteger;

public class Test2 {
    public static void main(String[] args){
        BigInteger b1=new BigInteger("123456789");
        BigInteger b2=new BigInteger("12345");
        //加法
        BigInteger b3=b1.add(b2);
        System.out.println(b3); //123469134
        //减法
        BigInteger b4=b1.subtract(b2);
        System.out.println(b4); //123444444
        //乘法
        BigInteger b5=b1.multiply(b2);
        System.out.println(b5); //1524074060205
        //除法（获取商）
        BigInteger b6=b1.divide(b2);
        System.out.println(b6); //10000
        //除法（获取商和余数）
        BigInteger[] b7=b1.divideAndRemainder(b2);
        System.out.println(b7[0]); //10000
        System.out.println(b7[1]); //6789
        //比较
        System.out.println(b1.equals(b2)); //false
        //次幂
        BigInteger b8=b1.pow(4); 
        System.out.println(b8); //232305722798259244150093798251441
        //最大值/最小值
        System.out.println(b3.max(b4)); //123469134
        System.out.println(b3.min(b4)); //123444444
        //转换基本数据类型
        BigInteger b9=BigInteger.valueOf(250);
        int result1=b9.intValue();
        System.out.println(result1); //250
        long result2=b9.longValue();
        System.out.println(result2); //250
        double result3=b9.doubleValue();
        System.out.println(result3); //250.0
    }
}
