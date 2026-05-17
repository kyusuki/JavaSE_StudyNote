package taskSix;

import java.math.BigInteger;
import java.util.Random;

public class Test1 {
    public static void main(String[] args){
        //1.获取一个随机的大整数
        Random r=new Random();
        for(int i=0;i<50;i++){
            BigInteger b1=new BigInteger(20,r);
            System.out.print(b1+" "); //0到2的20次方减一之间随机
        }
        System.out.println();
        //2.获取一个指定的大整数
        BigInteger b2=new BigInteger("12345678987654321");
        System.out.println(b2);
        //3.获取一个指定进制的大整数
        BigInteger b3=new BigInteger("1000",2);
        System.out.println(b3);
        //4.静态方法获取
        /*
         * 细节
         * 1.此方法表示的范围较小，只在long范围之内
         * 2.在内部对-16到16进行了优化，多次获取其中的值不会重新创建对像
         */
        BigInteger b5=BigInteger.valueOf(10000);
        System.out.println(b5);
        BigInteger b6=BigInteger.valueOf(16);
        BigInteger b7=BigInteger.valueOf(16);
        System.out.println(b6==b7); //true 复用一个地址的16
        BigInteger b8=BigInteger.valueOf(17);
        BigInteger b9=BigInteger.valueOf(17);
        System.out.println(b8==b9); //false
        //5.对象一旦创建，内部的数据不能发生改变
        BigInteger b10=BigInteger.valueOf(1);
        BigInteger b11=BigInteger.valueOf(2);
        BigInteger result=b10.add(b11); //只要进行计算都会产生一个新的BigInteger对象
        System.out.println(result);
    }
}
