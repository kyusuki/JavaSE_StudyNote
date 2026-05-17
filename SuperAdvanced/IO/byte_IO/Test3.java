package byte_IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) throws IOException{
        /*
         * 换行：
         *    windows系统中为：\r\n
         *    Liux系统中为：\n
         *    Mac系统中为：\r
         * 
         * 续写：
         *    在创建对象时，有第二个参数
         *    默认为false，创建对象时会清空文件
         *    改为true后，不会清空文件，会在文件末尾续写
         */
        

        FileOutputStream fos=new FileOutputStream("E:\\5e\\c.txt");
        String str1="hello world";
        byte[] bytes1=str1.getBytes();
        fos.write(bytes1);

        String wrap="\r\n";
        byte[] bytes2=wrap.getBytes();
        fos.write(bytes2);

        String str2="hello java";
        byte[] bytes3=str2.getBytes();
        fos.write(bytes3);

        fos.close();
    }
}
