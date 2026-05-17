package taskSeven;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test2 {
    public static void main(String[] args){
        BigDecimal b1=new BigDecimal("1.23");
        BigDecimal b2=new BigDecimal("0.12");
        //加法
        BigDecimal b3=b1.add(b2);
        System.out.println(b3); //1.35
        //减法
        BigDecimal b4=b1.subtract(b2);
        System.out.println(b4); //1.11
        //乘法
        BigDecimal b5=b1.multiply(b2);
        System.out.println(b5); //0.1476
        //除法
        BigDecimal b6=b1.divide(b2);
        System.out.println(b6); //10.25
        //除法（精确）
        BigDecimal b7=b1.divide(b2,4,RoundingMode.HALF_UP);
        //或者 b7=b7.setScale(4,RoundingMode.HALF_UP);
        System.out.println(b7); //10.2500
    }
}
