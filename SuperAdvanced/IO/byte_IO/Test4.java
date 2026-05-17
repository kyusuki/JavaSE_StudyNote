package byte_IO;

import java.io.FileInputStream;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) throws IOException{
        /*
         * 1.创建字节输入流对象
         * 2.读入数据
         * 3.释放资源
         */

        FileInputStream fis=new FileInputStream("E:\\5e\\b.txt");
        int b=fis.read(); //115
        System.out.println((char)b); //s
        int a=fis.read(); //98
        System.out.println((char)a); //b
        fis.close();
    }
}
