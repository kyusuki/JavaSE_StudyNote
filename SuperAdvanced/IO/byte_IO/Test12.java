package byte_IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test12 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //编码的方法
        //UTF-8
        String str="Peter是畜生";
        byte[] bytes1=str.getBytes();
        System.out.println(Arrays.toString(bytes1)); //字节长度14

        //GBK
        byte[] bytes2=str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2)); //字节长度11

        //解码的方法
        //UTF-8
        String result1=new String(bytes1);
        System.out.println(result1);

        //GBK
        String result2=new String(bytes1,"GBK");
        System.out.println(result2);

        //Unicode
        String result3=new String(bytes1,"Unicode");
        System.out.println(result3);
    }
}
