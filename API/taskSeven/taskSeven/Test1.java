package taskSeven;

import java.math.BigDecimal;

public class Test1 {
    public static void main(String[] args){
        /*
         * 1.通过传递double类型的小数创建对象
         * 不建议使用，这样传递会导致数据不精确
         */
        BigDecimal b1=new BigDecimal(0.01);
        BigDecimal b2=new BigDecimal(0.09);
        System.out.println(b1); //0.01000000000000000020816681711721685132943093776702880859375
        System.out.println(b2); //0.0899999999999999966693309261245303787291049957275390625

        /*
         * 2.通过传递字符串表示的小数创建对象
         * 如果数字超过double取值范围，建议使用构造方法
         */
        BigDecimal b3=new BigDecimal("0.01");
        BigDecimal b4=new BigDecimal("0.09");
        System.out.println(b3); //0.01
        System.out.println(b4); //0.09

        /*
         * 3.静态方法创建对象
         * 如果数字不大，没有超过double取值范围，建议使用静态方法
         * 如果数字是0到10之间的整数，不会再重新创建而是复用
         */
        BigDecimal b5=BigDecimal.valueOf(10.5);
        System.out.println(b5);
    }
}
